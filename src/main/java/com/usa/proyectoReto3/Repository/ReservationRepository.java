package com.usa.proyectoReto3.Repository;

import com.usa.proyectoReto3.Model.Client;
import com.usa.proyectoReto3.Model.DTOs.TotalAllClient;
import com.usa.proyectoReto3.Model.Message;
import com.usa.proyectoReto3.Model.Reservation;
import com.usa.proyectoReto3.Repository.CrudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

    //RETO 5
    public List<Reservation> getReservationsBetweenDatesReport(Date fechaA, Date fechaB){
        return reservationCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(fechaA, fechaB);
    }

    public List<Reservation> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
    public List<TotalAllClient> getTopClients(){
        List<TotalAllClient> respuesta =new ArrayList<>();
        List<Object[]> reporte= reservationCrudRepository.getTotalReservationByClient();
        for (int i=0; i<reporte.size(); i++){
            respuesta.add(new TotalAllClient((Long) reporte.get(i)[1], (Client) reporte.get(i)[0]));
        }
        return respuesta;
    }
}
