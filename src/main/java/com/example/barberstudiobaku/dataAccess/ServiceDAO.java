package com.example.barberstudiobaku.dataAccess;

import com.example.barberstudiobaku.mapper.ServiceMapper;
import com.example.barberstudiobaku.model.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServiceDAO {
    private final JdbcTemplate jdbcTemplate;

    public ServiceDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Service> getAllServices() {
        String query = "SELECT * FROM services";
        return jdbcTemplate.query(query, new ServiceMapper());
    }

    public Service getServiceById(int id) {
        String query = "SELECT * FROM services WHERE id=?";
        return jdbcTemplate.queryForObject(query, new ServiceMapper(), id);
    }

    public void addService(Service service) {
        String query = "INSERT INTO services (name, price) VALUES (?, ?)";
        jdbcTemplate.update(query, service.getName(), service.getPrice());
    }

    public void updateService(Service service) {
        String query = "UPDATE services SET name=?, price=? WHERE id=?";
        jdbcTemplate.update(query, service.getName(), service.getPrice(), service.getId());
    }

    public void deleteService(int id) {
        String query = "DELETE FROM services WHERE id=?";
        jdbcTemplate.update(query, id);
    }
}
