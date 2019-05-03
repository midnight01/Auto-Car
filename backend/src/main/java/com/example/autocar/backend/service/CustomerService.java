package com.example.autocar.backend.service;

import com.example.autocar.backend.entity.Customer;
import com.example.autocar.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    //ลบข้อมูล
    public boolean deleteCustomer(Long id) {
        try {
            customerRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    //อัพเดทข้อข้อมูล
    public Optional<Customer> updateCustomer(Long id, Customer customer) {
        Optional<Customer>  customerOptional = customerRepository.findById(id);
        if(!customerOptional.isPresent()) {
            return customerOptional;
        }
        customer.setCustomerId(id);
        return Optional.of(customerRepository.save(customer));
    }
}
