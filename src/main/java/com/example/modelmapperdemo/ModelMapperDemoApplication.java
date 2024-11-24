package com.example.modelmapperdemo;

import com.example.modelmapperdemo.dao.entities.Customer;
import com.example.modelmapperdemo.dtos.CustomerDtoNew;
import com.example.modelmapperdemo.mappers.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class ModelMapperDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ModelMapperDemoApplication.class, args);
    }
    @Autowired
    private CustomerMapper customerMapper;

    @Bean
    public CommandLineRunner start() {
        return args -> {
            // Création des customers
            Customer customer1 = Customer.builder()
                    .id(1L)
                    .name("John Doe")
                    .email("john.doe@example.com")
                    .password("securepassword")
                    .build();

            Customer customer2 = Customer.builder()
                    .id(2L)
                    .name("Jane Smith")
                    .email("jane.smith@example.com")
                    .password("securepassword")
                    .build();

            // Ajouter les customers à une liste
            List<Customer> customers = List.of(customer1, customer2);

            // Convertir les customers en CustomerDtoNew
            List<CustomerDtoNew> customerDtoNewList = customers.stream()
                    .map(customerMapper::fromCustomerToNewDto)
                    .collect(Collectors.toList());

            // Afficher les CustomerDtoNew
            customerDtoNewList.forEach(dto -> System.out.println(dto));
        };
    }
}
