package com.example.modelmapperdemo.mappers;

import com.example.modelmapperdemo.dao.entities.Customer;
import com.example.modelmapperdemo.dtos.CustomerDTO;
import com.example.modelmapperdemo.dtos.CustomerDtoNew;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    private ModelMapper modelMapper = new ModelMapper();

    // Conversion vers CustomerDTO
    public CustomerDTO fromCustomer(Customer customer) {
        return this.modelMapper.map(customer, CustomerDTO.class);
    }

    // Nouvelle conversion vers CustomerDtoNew
    public CustomerDtoNew fromCustomerToNewDto(Customer customer) {
        return this.modelMapper.map(customer, CustomerDtoNew.class);
    }
}
