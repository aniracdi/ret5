package com.usa.proyectoReto3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name= "costumes")
public class Costume implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    @Column(name = "years")
    private Integer year;
    private String description;


    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("costumes")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "costume")
    @JsonIgnoreProperties({"costumes", "client"})
    private List<Message> message;
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "costume")
    @JsonIgnoreProperties({"costumes", "messages"})
    public List<Reservation> reservation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }
}
