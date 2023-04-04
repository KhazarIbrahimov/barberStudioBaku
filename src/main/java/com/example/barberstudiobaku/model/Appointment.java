package com.example.barberstudiobaku.model;

import java.time.LocalDateTime;

public class Appointment {
    private int id;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Customer customer;
    private Barber barber;

    public Appointment(int id, LocalDateTime startDateTime, LocalDateTime endDateTime, Customer customer, Barber barber) {
        this.id = id;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.customer = customer;
        this.barber = barber;
    }

    // getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDateTime getStartDateTime() { return startDateTime; }
    public void setStartDateTime(LocalDateTime startDateTime) { this.startDateTime = startDateTime; }

    public LocalDateTime getEndDateTime() { return endDateTime; }
    public void setEndDateTime(LocalDateTime endDateTime) { this.endDateTime = endDateTime; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Barber getBarber() { return barber; }
    public void setBarber(Barber barber) { this.barber = barber; }
}
