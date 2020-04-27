package com.gridu.BEProgram.services;

import com.gridu.BEProgram.exceptions.ResourceNotFoundException;
import com.gridu.BEProgram.entities.Dog;

import java.util.List;

public interface DogService {

	List<Dog> showDogs();

	Dog createDog(Dog theDog);

	Dog getDog(int theId) throws ResourceNotFoundException;

	Dog updateDog(Dog theDog) throws ResourceNotFoundException;

	Dog deleteDog(int theId) throws ResourceNotFoundException;
	
}
