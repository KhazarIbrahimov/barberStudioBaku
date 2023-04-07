package com.example.barberstudiobaku.dto;


public class CustomerDTO {
    private Long id;
    private String FirstName;
    private String LastName;
    private String phone;
    private String email;


    public CustomerDTO( Long id, String firstName, String lastName, String phone, String email) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public CustomerDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

