package com.usa.proyectoReto3.Service;

import com.usa.proyectoReto3.Model.Costume;
import com.usa.proyectoReto3.Repository.CostumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostumeService {

    @Autowired
    private CostumeRepository costumeRepository;

    public List<Costume> getAll(){
        return (List<Costume>) costumeRepository.getAll();
    }

    public Optional<Costume> getCostume(int id){
        return costumeRepository.getCostume(id);
    }

    public Costume save(Costume costume){
        if(validarCampos(costume)){
            if(costume.getId()==null){
                return costumeRepository.save(costume);
            }else {
                Optional<Costume> costumeEncontrado= getCostume(costume.getId());
                if(costumeEncontrado.isEmpty()){
                    return costumeRepository.save(costume);
                }else {
                    return costume;
                }
            }
        }
        return costume;
    }
    public Costume update(Costume costume){
        if(validarCampos(costume)) {
            if (costume.getId() != null) {
                Optional<Costume> costumeEncontrado = getCostume(costume.getId());
                if (!costumeEncontrado.isEmpty()) {
                    if (costume.getName() != null) {
                        costumeEncontrado.get().setName(costume.getName());
                    }
                    if (costume.getBrand() != null) {
                        costumeEncontrado.get().setBrand(costume.getBrand());
                    }
                    if (costume.getYear() != null) {
                        costumeEncontrado.get().setYear(costume.getYear());
                    }
                    if (costume.getDescription() != null) {
                        costumeEncontrado.get().setDescription(costume.getDescription());
                    }
                    if (costume.getCategory() != null) {
                        costumeEncontrado.get().setCategory(costume.getCategory());
                    }
                    return costumeRepository.save(costumeEncontrado.get());
                }

            }
            return costume;
        }
        return costume;
    }

    public boolean delete(int id){
        Boolean resultado= getCostume(id).map(elemento ->{
            costumeRepository.delete(elemento);
            return true;
        }).orElse(false);
        return resultado;
    }

    public boolean validarCampos(Costume costume){
        return (costume.getBrand().length()<= 45 && costume.getName().length()<=45 &&
                String.valueOf(costume.getYear()).length()==4 && costume.getDescription().length()<=250);
    }
}
