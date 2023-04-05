package com.example.barberstudiobaku.mapper;

import com.example.barberstudiobaku.model.Service;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class ServiceMapper implements RowMapper<Service>{

    public Service mapRow(ResultSet rs, int rowNum) throws SQLException {
        Service service = new Service();
        service.setId((long) rs.getInt("id"));
        service.setName(rs.getString("name"));
        service.setPrice(rs.getDouble("price"));
        return service;
    }

}
