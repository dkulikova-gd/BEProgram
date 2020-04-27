package com.gridu.BEProgram.DAOs;

import com.gridu.BEProgram.entities.Dog;

import java.util.List;

public interface DogDAO {
    List<Dog> allDogs();
    Dog add(Dog dog);
    Dog delete(int id);
    Dog edit(Dog dog);
    Dog getById(int id);
}
