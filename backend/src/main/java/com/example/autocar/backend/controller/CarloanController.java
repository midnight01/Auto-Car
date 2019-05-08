package com.example.autocar.backend.controller;

import com.example.autocar.backend.entity.Carloan;
import com.example.autocar.backend.entity.Specification;
import com.example.autocar.backend.message.ResponseMessage;
import com.example.autocar.backend.repository.CarloanRepository;
import com.example.autocar.backend.repository.SpecificationRepository;
import com.example.autocar.backend.service.CarloanService;
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
public class CarloanController {

    @Autowired
    private CarloanRepository carloanRepository;

    @Autowired
    private CarloanService carloanService;

    @Autowired
    private SpecificationRepository specificationRepository;


    @GetMapping(path = "/Carloan")
    public Collection<Carloan> Carloan() {
        return carloanRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "/Carloan/save/{deposit}/{Financing}/{payment}/{specificationId}")
    public ResponseEntity<?> newCarloan(@RequestBody Carloan newCarloan,@PathVariable float deposit,@PathVariable float Financing,@PathVariable float payment,@PathVariable Long specificationId) {

        Specification specification = specificationRepository.findBySpecificationId(specificationId);

        Carloan carloan = new Carloan();
        carloan.setNumberInstallment(newCarloan.getNumberInstallment());
        carloan.setInterest(newCarloan.getInterest());
        carloan.setDeposit(deposit);
        carloan.setFinancing(Financing);
        carloan.setPayment(payment);
        carloan.setSpecification(specification);

        carloanRepository.save(carloan);
        return ResponseEntity.ok().body(carloan.getCarloanId());
    }

    @DeleteMapping("/Carloan/delete/{id}")
    public ResponseEntity<?> deleteCarloan(@PathVariable Long id) {
        if(!carloanService.deleteCarloan(id)) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(new ResponseMessage("Delete Data successfully!"), HttpStatus.OK);
    }

    @PutMapping("/Carloan/update/{id}")
    public ResponseEntity<?> updateCarloan(@PathVariable Long id, @Valid @RequestBody Carloan carloan) {
        Optional<Carloan> carloan1 = carloanService.updateCarloan(id, carloan);
        if(!carloan1.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(new ResponseMessage("Update Data successfully!"), HttpStatus.OK);
    }

    @GetMapping(path = "/Carloan/{carloanId}")
    private ResponseEntity<Carloan> findByCarloanId(@PathVariable long carloanId){
        System.out.println(carloanId);
        Carloan carloan = carloanRepository.findByCarloanId(carloanId);
        if(carloan == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(carloan);
    }

}
