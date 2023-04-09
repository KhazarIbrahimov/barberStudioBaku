package com.example.barberstudiobaku.controller;

import com.example.barberstudiobaku.business.AppointmentService;
import com.example.barberstudiobaku.dto.AppointmentDTO;
import com.example.barberstudiobaku.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public AppointmentDTO getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    @PostMapping
    public void addAppointment(@RequestBody AppointmentDTO appointment) {
        appointmentService.addAppointment(appointment);
    }

    @PutMapping
    public void updateAppointment(@RequestBody Appointment appointment) {
        appointmentService.updateAppointment(appointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable int id) {
        appointmentService.deleteAppointment((long) id);
    }
}
