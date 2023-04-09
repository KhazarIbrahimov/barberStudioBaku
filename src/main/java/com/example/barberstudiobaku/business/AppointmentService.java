package com.example.barberstudiobaku.business;

import com.example.barberstudiobaku.dto.AppointmentDTO;
import com.example.barberstudiobaku.model.Appointment;
import com.example.barberstudiobaku.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<AppointmentDTO> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public AppointmentDTO getAppointmentById(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            return convertToDTO(appointment.get());
        }
        return null;
    }

    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = convertToEntity(appointmentDTO);
        appointment = appointmentRepository.save(appointment);
        return convertToDTO(appointment);
    }

    public AppointmentDTO updateAppointment(Long id, AppointmentDTO appointmentDTO) {
        Optional<Appointment> existingAppointment = appointmentRepository.findById(id);
        if (existingAppointment.isPresent()) {
            Appointment appointment = existingAppointment.get();
            appointment.setBarber(appointmentDTO.getBarber());
            appointment.setCustomer(appointmentDTO.getCustomer());
            appointment.setService(appointmentDTO.getService());
            appointment.setStartDateTime(appointmentDTO.getStartDateTime());
            appointment.setEndDateTime(appointmentDTO.getEndDateTime());
            appointment = appointmentRepository.save(appointment);
            return convertToDTO(appointment);
        }
        return null;
    }

    public boolean deleteAppointment(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            appointmentRepository.delete(appointment.get());
            return true;
        }
        return false;
    }

    private AppointmentDTO convertToDTO(Appointment appointment) {
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setId(appointment.getId());
        appointment.setBarber(appointmentDTO.getBarber());
        appointment.setCustomer(appointmentDTO.getCustomer());
        appointment.setService(appointmentDTO.getService());
        appointment.setStartDateTime(appointmentDTO.getStartDateTime());
        appointment.setEndDateTime(appointmentDTO.getEndDateTime());
        return appointmentDTO;
    }

    private Appointment convertToEntity(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        appointment.setBarber(appointmentDTO.getBarber());
        appointment.setCustomer(appointmentDTO.getCustomer());
        appointment.setService(appointmentDTO.getService());
        appointment.setStartDateTime(appointmentDTO.getStartDateTime());
        appointment.setEndDateTime(appointmentDTO.getEndDateTime());
        return appointment;
    }

    public void addAppointment(AppointmentDTO appointment) {
        this.appointmentRepository.save(convertToEntity(appointment));
    }

    public void updateAppointment(Appointment appointment) {
        this.appointmentRepository.save(appointment);
    }
}
