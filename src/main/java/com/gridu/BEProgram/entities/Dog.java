package com.gridu.BEProgram.entities;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "dogs")
public class Dog {

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Length(min = 1, max = 100)
    @Column(name ="name")
    String name;

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
    @Column(name ="dateOfBirth")
    String dateOfBirth;

    @Min(0)
    @Column(name ="height")
    Float height;

    @Min(0)
    @Column(name ="weight")
    Float weight;

    public Dog() {
    }

    public Dog(Integer id, String name, String dateOfBirth, Float height, Float weight) {
        this.id=id;
        this.name=name;
        this.dateOfBirth=dateOfBirth;
        this.height=height;
        this.weight=weight;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
