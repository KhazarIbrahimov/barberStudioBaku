package com.example.barberstudiobaku.repository;

import com.example.barberstudiobaku.model.Appointment;
import com.example.barberstudiobaku.model.Barber;
import com.example.barberstudiobaku.model.Customer;
import com.example.barberstudiobaku.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {


    List<Appointment> findByDate(LocalDate date);

    List<Appointment> findByBarberAndDateBetween(Barber barber, LocalDate startDate, LocalDate endDate);

    List<Appointment> findByCustomerAndDateBetween(Customer customer, LocalDate startDate, LocalDate endDate);

    List<Appointment> findByServiceAndDateBetween(Service service, LocalDate startDate, LocalDate endDate);

}

