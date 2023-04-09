package com.example.barberstudiobaku.dto;


import com.example.barberstudiobaku.model.Barber;
import com.example.barberstudiobaku.model.Customer;
import com.example.barberstudiobaku.model.Service;

import java.time.LocalDateTime;

public class AppointmentDTO {

    private long id;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Customer customer;
    private Barber barber;
    private Service service;

    public AppointmentDTO(long id, LocalDateTime startDateTime, LocalDateTime endDateTime, Customer customer, Barber barber, Service service) {
        this.id = id;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.customer = customer;
        this.barber = barber;
        this.service = service;
    }

    public AppointmentDTO() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Barber getBarber() {
        return barber;
    }

    public void setBarber(Barber barber) {
        this.barber = barber;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
