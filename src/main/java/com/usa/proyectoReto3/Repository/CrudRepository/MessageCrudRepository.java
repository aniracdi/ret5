package com.usa.proyectoReto3.Repository.CrudRepository;

import com.usa.proyectoReto3.Model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
