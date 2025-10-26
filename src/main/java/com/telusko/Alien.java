package com.telusko;
//Creating or changing table in database

import jakarta.persistence.*;

import java.util.List;

@Entity

//if you want to  chnage table name we have to use @Table annotation otherwise Hibernate will take class name as tablename because of @Entity annotation
//@Table(name="alien_table")
public class Alien {
   @Id
    private int aid;
   //@Column(name="alien_name")      //@column annotation will change the column name
    private String aname;
 //  @Transient    //it used for ignoring the Column
    private String tech;
//    @OneToOne        //annotation used for one to one relation
//    private Laptop laptop;

    //for OneToMany relationship
//    @OneToMany(mappedBy = "alien")       //Mapped by alien  laptop
//    private List<Laptop> laptops;


    //For Many to Many Relation
    @ManyToMany
    private List<Laptop> laptops;
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

//    public Laptop getLaptop() {
//        return laptop;
//    }
//
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                ", laptop=" + laptops +
                '}';
    }
}
