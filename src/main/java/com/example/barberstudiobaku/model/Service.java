package com.example.barberstudiobaku.model;

import jakarta.persistence.*;

    @Entity
    @Table(name = "services")
    public class Service {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        private double price;


        public Service() {
        }

        public Service(String name, double price) {
            this.name = name;
            this.price = price;
        }


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

    }
