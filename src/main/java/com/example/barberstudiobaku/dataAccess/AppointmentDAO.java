package com.example.barberstudiobaku.dataAccess;


import com.example.barberstudiobaku.model.Appointment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AppointmentDAO {

    private final JdbcTemplate jdbcTemplate;

    public AppointmentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Appointment> getAllAppointments() {
        String sql = "SELECT * FROM appointments";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Appointment.class));
    }

    public Appointment getAppointmentById(int id) {
        String sql = "SELECT * FROM appointments WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Appointment.class));
    }

    public void addAppointment(Appointment appointment) {
        String sql = "INSERT INTO appointments (barber_id, customer_id, service_id, date_time) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, appointment.getBarber(), appointment.getCustomer(), appointment.getService(), appointment.getStartDateTime());
    }

    public void updateAppointment(Appointment appointment) {
        String sql = "UPDATE appointments SET barber_id = ?, customer_id = ?, service_id = ?, date_time = ? WHERE id = ?";
        jdbcTemplate.update(sql, appointment.getBarber(), appointment.getCustomer(), appointment.getService(), appointment.getStartDateTime(), appointment.getId());
    }

    public void deleteAppointment(int id) {
        String sql = "DELETE FROM appointments WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}

