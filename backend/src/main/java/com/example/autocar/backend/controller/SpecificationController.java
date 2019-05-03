package com.example.autocar.backend.controller;

import com.example.autocar.backend.entity.Specification;
import com.example.autocar.backend.message.ResponseMessage;
import com.example.autocar.backend.repository.SpecificationRepository;
import com.example.autocar.backend.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/data")
public class SpecificationController {

    @Autowired
    private SpecificationRepository specificationRepository;

    @Autowired
    private SpecificationService specificationService;



    @GetMapping(path = "/Specification")
    public Collection<Specification> Specification() {
        return specificationRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "/Specification/save")
    public ResponseEntity<?> newSpecification(@RequestBody Specification newSpecification){

        Specification s = new Specification();
        s.setTypeCar(newSpecification.getTypeCar());
        s.setBrand(newSpecification.getBrand());
        s.setGeneration(newSpecification.getGeneration());
        s.setCarMakeover(newSpecification.getCarMakeover());
        s.setModelDetails(newSpecification.getModelDetails());
        s.setYear(newSpecification.getYear());
        s.setEngineSize(newSpecification.getEngineSize());
        s.setGearSystem(newSpecification.getGearSystem());
        s.setNumberSeats(newSpecification.getNumberSeats());
        s.setMileage(newSpecification.getMileage());
        s.setColor(newSpecification.getColor());
        s.setPrice(newSpecification.getPrice());
        s.setImage(newSpecification.getImage());

        specificationRepository.save(s);
        return new ResponseEntity<>(new ResponseMessage("Save Data successfully!"), HttpStatus.OK);
    }

    @GetMapping(path = "/Specification/{specificationId}")
    private ResponseEntity<Specification> findBySpecificationId(@PathVariable long specificationId){
        System.out.println(specificationId);
        Specification specification = specificationRepository.findBySpecificationId(specificationId);
        if(specification == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(specification);
    }

    @DeleteMapping("/Specification/delete/{id}")
    public ResponseEntity<?> deleteSpecification(@PathVariable Long id) {
        if(!specificationService.deleteSpecification(id)) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(new ResponseMessage("Delete Data successfully!"), HttpStatus.OK);
    }

    @PutMapping("/Specification/update/{id}")
    public ResponseEntity<?> updateSpecification(@PathVariable Long id, @Valid @RequestBody Specification specification) {
        Optional<Specification> specification1 = specificationService.updateSpecification(id, specification);
        if(!specification1.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(new ResponseMessage("Update Data successfully!"), HttpStatus.OK);
    }

}
