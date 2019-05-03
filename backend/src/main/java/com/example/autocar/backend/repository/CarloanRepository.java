package com.example.autocar.backend.repository;

import com.example.autocar.backend.entity.Carloan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarloanRepository extends JpaRepository<Carloan, Long> {
    Carloan findByCarloanId(Long carloanId);
}
