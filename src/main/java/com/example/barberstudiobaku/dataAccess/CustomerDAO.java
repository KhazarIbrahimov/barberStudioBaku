package com.example.barberstudiobaku.dataAccess;

import com.example.barberstudiobaku.mapper.CustomerMapper;
import com.example.barberstudiobaku.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM customers";
        return jdbcTemplate.query(sql, new CustomerMapper());
    }

    public Customer getCustomerById(int id) {
        String sql = "SELECT * FROM customers WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CustomerMapper());
    }

    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO customers (name, email, phone) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, customer.getFirstName(), customer.getEmail(), customer.getPhone());
    }

    public void updateCustomer(int id, Customer customer) {
        String sql = "UPDATE customers SET name = ?, email = ?, phone = ? WHERE id = ?";
        jdbcTemplate.update(sql, customer.getFirstName(), customer.getEmail(), customer.getPhone(), customer.getId());
    }

    public void deleteCustomer(int id) {
        String sql = "DELETE FROM customers WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public int createCustomer(Customer customer) {
        String sql = "INSERT INTO customers (name, email, phone) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, customer.getFirstName(), customer.getEmail(), customer.getPhone());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
    }
}

