package com.example.barberstudiobaku.mapper;

import com.example.barberstudiobaku.model.Customer;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CustomerMapper implements RowMapper<Customer> {

    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getLong("id"));
        customer.setFirstName(rs.getString("first_name"));
        customer.setLastName(rs.getString("last_name"));
        customer.setEmail(rs.getString("email"));
        customer.setPhone(rs.getString("phone_number"));
        return customer;
    }

    public SqlParameterSource getSqlParameterSource(Customer customer) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", customer.getId());
        parameterSource.addValue("first_name", customer.getFirstName());
        parameterSource.addValue("last_name", customer.getLastName());
        parameterSource.addValue("email", customer.getEmail());
        parameterSource.addValue("phone_number", customer.getPhone());
        return parameterSource;
    }
}

