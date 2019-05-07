package com.example.autocar.backend.entity;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;

@Entity
public class Carloan {

    @Id
    @SequenceGenerator(name = "carloan_seq", sequenceName = "carloan_seq")
    @GeneratedValue(generator = "carloan_seq", strategy = GenerationType.SEQUENCE)
    private Long carloanId;

    private String numberInstallment;
    private String interest;
    @NumberFormat
    private float deposit;
    @NumberFormat
    private float financing;
    @NumberFormat
    private float payment;

    @ManyToOne
    private Specification specification;

    public Carloan(){}

    public String getNumberInstallment() {
        return numberInstallment;
    }

    public void setNumberInstallment(String numberInstallment) {
        this.numberInstallment = numberInstallment;
    }

    public Long getCarloanId() {
        return carloanId;
    }

    public void setCarloanId(Long carloanId) {
        this.carloanId = carloanId;
    }

    public float getDeposit() {
        return deposit;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public float getFinancing() {
        return financing;
    }

    public void setFinancing(float financing) {
        this.financing = financing;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }
}
