package com.usa.proyectoReto3.Repository;


import com.usa.proyectoReto3.Model.Costume;
import com.usa.proyectoReto3.Repository.CrudRepository.CostumeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CostumeRepository {
    @Autowired
    private CostumeCrudRepository costumeCrudRepository;

    public List<Costume> getAll(){
        return (List<Costume>) costumeCrudRepository.findAll();
    }
    public Optional<Costume> getCostume(int id){
        return costumeCrudRepository.findById(id);
    }
    public Costume save(Costume category){
        return costumeCrudRepository.save(category);
    }
    public void delete(Costume category){
        costumeCrudRepository.delete(category);
    }
}
