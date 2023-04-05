package com.example.barberstudiobaku.mapper;

import com.example.barberstudiobaku.model.Barber;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class BarberMapper implements RowMapper<Barber> {

        @Override
        public Barber mapRow(ResultSet rs, int rowNum) throws SQLException {
            Barber barber = new Barber();
            barber.setId(rs.getInt("id"));
            barber.setName(rs.getString("name"));
            barber.setPhoneNumber(rs.getString("phone"));
            barber.setEmail(rs.getString("email"));
            return barber;
        }
}
