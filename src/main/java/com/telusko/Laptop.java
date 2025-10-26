package com.telusko;

import jakarta.persistence.*;

import java.util.List;

/*@Embeddable    //Embeddable annotation will Embedded this Laptop fields in Entity Table

public class Laptop {
    private String brand;
    private String model;
    private  int ram;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }
} */



//For Mapping one-one- Relationship and ManyToOne and OneToMany.... ManyToMany

@Entity
public class Laptop{
    @Id
    private int lid;
    private String brand;
    private String model;
    private  int ram;

    //Creating alien ref for One Alien has Many Laptops
//    @ManyToOne        //for Laptop perspective many lap to one alien
//    private Alien alien;

    //ManyToMany

    @ManyToMany(mappedBy = "laptops")
    private List<Alien> alien;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }
//
//    public Alien getAlien() {
//        return alien;
//    }
//
//    public void setAlien(Alien alien) {
//        this.alien = alien;
//    }


    public List<Alien> getAlien() {
        return alien;
    }

    public void setAlien(List<Alien> alien) {
        this.alien = alien;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }
}
