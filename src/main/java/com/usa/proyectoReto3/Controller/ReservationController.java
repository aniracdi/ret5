package com.usa.proyectoReto3.Controller;


import com.usa.proyectoReto3.Model.Admin;
import com.usa.proyectoReto3.Model.DTOs.CompletedAndCancelled;
import com.usa.proyectoReto3.Model.DTOs.TotalAllClient;
import com.usa.proyectoReto3.Model.Reservation;

import com.usa.proyectoReto3.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id){

        return reservationService.getReservation(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation (@PathVariable("id") int id){
        return reservationService.deleteReservation(id);
    }

    //RETO 5
    @GetMapping("/report-dates/{fecha1}/{fecha2}")
    public List<Reservation> getReservationsBetweenDatesReport (@PathVariable("fecha1") String fecha1, @PathVariable ("fecha2") String fecha2){
        return reservationService.getReservationsBetweenDatesReport(fecha1, fecha2);
    }

    @GetMapping("/report-status")
    public CompletedAndCancelled getReservationsStatusReport(){
        return reservationService.getReservationStatusReport();
    }

    @GetMapping("/report-clients")
    public List<TotalAllClient> getTopClientsReport(){
        return reservationService.getTopClientsReport();
    }

}




