package com.example.autocar.backend.entity;


import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Specification {
    @Id
    @SequenceGenerator(name = "specification_seq", sequenceName = "specification_seq")
    @GeneratedValue(generator = "specification_seq", strategy = GenerationType.SEQUENCE)

    @NonNull
    private Long specificationId;
    @NonNull
    private String typeCar;
    @NonNull
    private String brand;
    @NonNull
    private String generation;
    @NonNull
    private String carMakeover;
    @NonNull
    private String modelDetails;
    @NonNull
    private int year;
    @NonNull
    private float engineSize;
    @NonNull
    private String gearSystem;
    @NonNull
    private int numberSeats;
    @NonNull
    private int mileage;
    @NonNull
    private String color;
    private int price;

    private  String image;

    public Specification(){}


    public Long getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Long specificationId) {
        this.specificationId = specificationId;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public String getCarMakeover() {
        return carMakeover;
    }

    public void setCarMakeover(String carMakeover) {
        this.carMakeover = carMakeover;
    }

    public String getModelDetails() {
        return modelDetails;
    }

    public void setModelDetails(String modelDetails) {
        this.modelDetails = modelDetails;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(float engineSize) {
        this.engineSize = engineSize;
    }

    public String getGearSystem() {
        return gearSystem;
    }

    public void setGearSystem(String gearSystem) {
        this.gearSystem = gearSystem;
    }

    public int getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(int numberSeats) {
        this.numberSeats = numberSeats;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
