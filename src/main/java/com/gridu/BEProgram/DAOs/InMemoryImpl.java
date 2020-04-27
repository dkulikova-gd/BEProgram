package com.gridu.BEProgram.DAOs;

import com.gridu.BEProgram.entities.Dog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository(value = "InMemory")
public class InMemoryImpl implements DogDAO {

    private static List<Dog> dataBase = new ArrayList<>();
    private int id =1;

    @Override
    public List<Dog> allDogs() {
        return dataBase;
    }

    @Override
    public Dog add(Dog dog) {
        dog.setId(id);
        id++;
        dataBase.add(dog);
        return dog;
    }

    @Override
    public Dog delete(int id) {
        for (Dog dog: dataBase){
            if (dog.getId()==id){
                dataBase.remove(dog);
                return dog;
            }
        }
        return null;
    }

    @Override
    public Dog edit(Dog dog) {
        for (Dog row: dataBase){
            if (row.getId()==dog.getId()){
                dataBase.remove(row);
                dog.setId(row.getId());
                dataBase.add(dog);
                return dog;
            }
        }
        return null;
    }

    @Override
    public Dog getById(int id) {
        for (Dog dog: dataBase){
            if (dog.getId()==id){
                return dog;
            }
        }
        return null;
    }
}
