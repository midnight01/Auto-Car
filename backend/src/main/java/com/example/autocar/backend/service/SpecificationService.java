package com.example.autocar.backend.service;


import com.example.autocar.backend.entity.Specification;
import com.example.autocar.backend.repository.SpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpecificationService {

    private SpecificationRepository specificationRepository;


    @Autowired
    public SpecificationService(SpecificationRepository specificationRepository){
        this.specificationRepository = specificationRepository;
    }

    //ลบข้อมูล
    public boolean deleteSpecification(Long id) {
        try {
            specificationRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    //อัพเดทข้อข้อมูล
    public Optional<Specification> updateSpecification(Long id, Specification specification) {
        Optional<Specification>  customerOptional = specificationRepository.findById(id);
        if(!customerOptional.isPresent()) {
            return customerOptional;
        }
        specification.setSpecificationId(id);
        return Optional.of(specificationRepository.save(specification));
    }
}
