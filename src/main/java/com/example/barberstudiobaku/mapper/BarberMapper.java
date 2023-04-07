package com.example.barberstudiobaku.mapper;

import com.example.barberstudiobaku.dto.BarberDTO;
import com.example.barberstudiobaku.model.Barber;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class BarberMapper implements RowMapper<Barber> {

    public static BarberDTO toBarberDTO(Barber barber) {
        BarberDTO barberDTO = new BarberDTO();
        barberDTO.setId((long) barber.getId());
        barberDTO.setName(barber.getName());
        barberDTO.setPhoneNumber(barber.getPhoneNumber());
        barberDTO.setEmail(barber.getEmail());
        return barberDTO;
    }

    public static Barber toBarber(BarberDTO barberDTO) {
        Barber barber = new Barber();
        barber.setId(barberDTO.getId().intValue());
        barber.setName(barberDTO.getName());
        barber.setPhoneNumber(barberDTO.getPhoneNumber());
        barber.setEmail(barberDTO.getEmail());
        return barber;
    }

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
