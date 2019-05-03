package com.example.autocar.backend.service;

import com.example.autocar.backend.entity.Carloan;
import com.example.autocar.backend.repository.CarloanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarloanService {

    private CarloanRepository carloanRepository;

    @Autowired
    public CarloanService(CarloanRepository carloanRepository){
        this.carloanRepository = carloanRepository;
    }

    //ลบข้อมูล
    public boolean deleteCarloan(Long id) {
        try {
            carloanRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    //อัพเดทข้อข้อมูล
    public Optional<Carloan> updateCarloan(Long id, Carloan carloan) {
        Optional<Carloan>  customerOptional = carloanRepository.findById(id);
        if(!customerOptional.isPresent()) {
            return customerOptional;
        }
        carloan.setCarloanId(id);
        return Optional.of(carloanRepository.save(carloan));
    }
}
