package com.usa.proyectoReto3.Service;

import com.usa.proyectoReto3.Model.DTOs.CompletedAndCancelled;
import com.usa.proyectoReto3.Model.DTOs.TotalAllClient;
import com.usa.proyectoReto3.Model.Reservation;
import com.usa.proyectoReto3.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        }else {
            Optional<Reservation> reservationEncontrado=getReservation(reservation.getIdReservation());
            if(reservationEncontrado.isEmpty()){
                return reservationRepository.save(reservation);
            }else {
                return reservation;
            }
        }
    }
    public Reservation update (Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> reservationEncontrado = getReservation(reservation.getIdReservation());
            if (!reservationEncontrado.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    reservationEncontrado.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    reservationEncontrado.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    reservationEncontrado.get().setStatus(reservation.getStatus());
                }
                return reservationRepository.save(reservationEncontrado.get());
            }
        }
        return reservation;
    }

    public boolean deleteReservation (int id){
        Boolean resultado =getReservation(id).map(elemento ->{
            reservationRepository.delete(elemento);
            return true;
        } ).orElse(false);
        return resultado;
    }

    //RETO 5

    public List<Reservation> getReservationsBetweenDatesReport (String fechaA, String fechaB){
        SimpleDateFormat parser= new SimpleDateFormat("yyyy-MM-dd");

        Date a= new Date();
        Date b= new Date();
        try{
            a= parser.parse(fechaA);
            b= parser.parse(fechaB);
        }catch (ParseException exception){
            exception.printStackTrace();

        }
        if(a.before(b)){
            return reservationRepository.getReservationsBetweenDatesReport(a,b);
        }else {
            return new ArrayList<>();
        }
    }

    public CompletedAndCancelled getReservationStatusReport(){
        List<Reservation> completed= reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");

        int cantidadCompletadas= completed.size();
        int cantidadCanceladas= cancelled.size();

        return new CompletedAndCancelled((long) cantidadCompletadas, (long) cantidadCanceladas);

    }

    public List<TotalAllClient> getTopClientsReport(){
        return reservationRepository.getTopClients();
    }


}
