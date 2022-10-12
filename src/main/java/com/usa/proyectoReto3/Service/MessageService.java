package com.usa.proyectoReto3.Service;

import com.usa.proyectoReto3.Model.Message;
import com.usa.proyectoReto3.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){

        return (List<Message>) messageRepository.getAll();
    }
    public Optional<Message> getMessage(int id){

        return messageRepository.getMessage(id);
    }

    public Message save(Message messages){
        if (validarCampos(messages)) {
            if (messages.getIdMessage() == null) {
                return messageRepository.save(messages);
            } else {
                Optional<Message> messageEncontrado = getMessage(messages.getIdMessage());
                if (messageEncontrado.isEmpty()) {
                    return messageRepository.save(messages);
                } else {
                    return messages;
                }
            }
        }
        return messages;
    }
    public Message update(Message messages){
        if (validarCampos(messages)) {
            if (messages.getIdMessage() != null) {
                Optional<Message> messageEncontrado = getMessage(messages.getIdMessage());
                if (!messageEncontrado.isEmpty()) {
                    if (messages.getMessageText() != null) {
                        messageEncontrado.get().setMessageText(messages.getMessageText());
                    }
                    return messageRepository.save(messageEncontrado.get());
                }
            }
            return messages;
        }
        return messages;
    }
    public boolean delete(int messageId){
        Boolean resultado=getMessage(messageId).map(elemento ->{
            messageRepository.delete(elemento);
            return true;
        } ).orElse(false);
        return resultado;
    }

    public boolean validarCampos(Message message){

        return (message.getMessageText().length()<=250);
    }
}
