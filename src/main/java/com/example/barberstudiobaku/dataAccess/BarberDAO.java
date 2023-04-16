package com.example.barberstudiobaku.dataAccess;


import com.example.barberstudiobaku.mapper.BarberMapper;
import com.example.barberstudiobaku.model.Barber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Repository
public class BarberDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @GetMapping("/barbers")


    public List<Barber> getAllBarbers() {
        String query = "SELECT * FROM barbers";
        List<Barber> barbers = jdbcTemplate.query(query, new BarberMapper());
        return barbers;
    }

    public Barber getBarberById(int id) {
        String query = "SELECT * FROM barbers WHERE id = ?";
        Barber barber = jdbcTemplate.queryForObject(query, new Object[]{id}, new BarberMapper());
        return barber;
    }

    public void addBarber(Barber barber) {
        String query = "INSERT INTO barbers (name, phone_number, email) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, barber.getName(), barber.getPhoneNumber(), barber.getEmail());
    }

    public void updateBarber(Barber barber) {
        String query = "UPDATE barbers SET name = ?, phone_number = ?, email = ? WHERE id = ?";
        jdbcTemplate.update(query, barber.getName(), barber.getPhoneNumber(), barber.getEmail(), barber.getId());
    }

    public void deleteBarber(int id) {
        String query = "DELETE FROM barbers WHERE id = ?";
        jdbcTemplate.update(query, id);
    }
}
