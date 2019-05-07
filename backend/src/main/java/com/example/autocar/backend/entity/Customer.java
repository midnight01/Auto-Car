package com.example.autocar.backend.entity;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq")
    @GeneratedValue(generator = "customer_seq", strategy = GenerationType.SEQUENCE)
    private Long customerId;

    private  String firstName;
    private  String lastName;
    private  String phoneNumber;
    private  String email;
    private  String idCardNumber;
    private  String workExperience;
    private  String salaryBase;
    private  String jobStatu;

    @ManyToOne
    private  Carloan carloan;
    public Customer(){}

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getSalaryBase() {
        return salaryBase;
    }

    public void setSalaryBase(String salaryBase) {
        this.salaryBase = salaryBase;
    }

    public String getJobStatu() {
        return jobStatu;
    }

    public void setJobStatu(String jobStatu) {
        this.jobStatu = jobStatu;
    }

    public Carloan getCarloan() {
        return carloan;
    }

    public void setCarloan(Carloan carloan) {
        this.carloan = carloan;
    }
}
