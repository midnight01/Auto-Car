package com.example.autocar.backend.controller;

import com.example.autocar.backend.entity.Carloan;
import com.example.autocar.backend.entity.Customer;
import com.example.autocar.backend.message.ResponseMessage;
import com.example.autocar.backend.repository.CarloanRepository;
import com.example.autocar.backend.repository.CustomerRepository;
import com.example.autocar.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/data")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CarloanRepository carloanRepository;


    @GetMapping(path = "/Customer")
    public Collection<Customer> Customer() {
        return customerRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "/Customer/save")
    public ResponseEntity<?> newCustomer(@RequestBody Customer newCustomer) {

//        Carloan carloan = carloanRepository.findByCarloanId(carloanId);
        Customer customer = new Customer();
        customer.setFirstName(newCustomer.getFirstName());
        customer.setLastName(newCustomer.getLastName());
        customer.setPhoneNumber(newCustomer.getPhoneNumber());
        customer.setEmail(newCustomer.getEmail());
        customer.setIdCardNumber(newCustomer.getIdCardNumber());
//        customer.setCarloan(carloan);
        customer.setJobStatu(newCustomer.getJobStatu());
        customer.setWorkExperience(newCustomer.getWorkExperience());
        customer.setSalaryBase(newCustomer.getSalaryBase());

        customerRepository.save(customer);
        return new ResponseEntity<>(new ResponseMessage("Save Data successfully!"), HttpStatus.OK);
    }

    @DeleteMapping("/Customer/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        if(!customerService.deleteCustomer(id)) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(new ResponseMessage("Delete Data successfully!"), HttpStatus.OK);
    }

    @PutMapping("/Customer/update/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @Valid @RequestBody Customer customer) {
        Optional<Customer> customer1 = customerService.updateCustomer(id, customer);
        if(!customer1.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(new ResponseMessage("Update Data successfully!"), HttpStatus.OK);
    }

    @GetMapping(path = "/Customer/{customerId}")
    private ResponseEntity<Customer> findByCustomerId(@PathVariable long customerId){
        System.out.println(customerId);
        Customer customer = customerRepository.findByCustomerId(customerId);
        if(customer == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(customer);
    }
}
