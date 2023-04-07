package com.example.barberstudiobaku.dto;


import java.time.LocalDateTime;

public class AppointmentDTO {

    private Long id;
    private CustomerDTO customer;
    private BarberDTO barber;
    private ServiceDTO service;
    private LocalDateTime appointmentTime;

    public AppointmentDTO() {
    }

    public AppointmentDTO(Long id, CustomerDTO customer, BarberDTO barber, ServiceDTO service, LocalDateTime appointmentTime) {
        this.id = id;
        this.customer = customer;
        this.barber = barber;
        this.service = service;
        this.appointmentTime = appointmentTime;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public BarberDTO getBarber() {
        return barber;
    }

    public void setBarber(BarberDTO barber) {
        this.barber = barber;
    }

    public ServiceDTO getService() {
        return service;
    }

    public void setService(ServiceDTO service) {
        this.service = service;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}
