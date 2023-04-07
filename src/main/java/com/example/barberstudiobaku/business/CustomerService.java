package com.example.barberstudiobaku.business;

import com.example.barberstudiobaku.dataAccess.CustomerDAO;
import com.example.barberstudiobaku.dto.CustomerDTO;
import com.example.barberstudiobaku.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerDAO.getAllCustomers();
        return customers.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public CustomerDTO getCustomerById(int id) {
        Customer customer = customerDAO.getCustomerById(id);
        return convertToDTO(customer);
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = convertToEntity(customerDTO);
        int id = customerDAO.createCustomer(customer);
        customerDTO.setId((long) id);
        return customerDTO;
    }

    public void updateCustomer(int id, CustomerDTO customerDTO) {
        Customer customer = convertToEntity(customerDTO);
        customerDAO.updateCustomer(id, customer);
    }

    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }

    private CustomerDTO convertToDTO(Customer customer) {
        return new CustomerDTO(customer.getId(), customer.getFirstName(), customer.getLastName(),
                customer.getEmail(), customer.getPhone());
    }

    private Customer convertToEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        return customer;
    }
}

