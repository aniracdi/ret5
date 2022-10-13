package com.usa.proyectoReto3.Model.DTOs;

import com.usa.proyectoReto3.Model.Client;

public class TotalAllClient {
    private Long total;
    private Client client;

    //Metodo constructor

    public TotalAllClient(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    //Setter y Getter

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
