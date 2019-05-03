package com.example.autocar.backend.repository;

import com.example.autocar.backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Long> {
    Customer findByCustomerId(Long customerId);
}
