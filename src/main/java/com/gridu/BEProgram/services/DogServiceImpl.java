package com.gridu.BEProgram.services;

import com.gridu.BEProgram.DAOs.DogDAO;
import com.gridu.BEProgram.DAOs.DogDAOImpl;
import com.gridu.BEProgram.exceptions.ResourceNotFoundException;
import com.gridu.BEProgram.entities.Dog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class DogServiceImpl implements DogService {

	private DogDAO dogDAO;

	@Autowired
	@Qualifier(value="DogDAO")
	public void setDogDAO(DogDAO dogDAO){
		this.dogDAO=dogDAO;
	}

	@Override
	@Transactional
	public List<Dog> showDogs() {
		return dogDAO.allDogs();
	}

	@Override
	@Transactional
	public Dog createDog(Dog theDog) {
		return dogDAO.add(theDog);
	}

	@Override
	@Transactional
	public Dog getDog(int theId) throws ResourceNotFoundException {
		return dogDAO.getById(theId);
	}

	@Override
	@Transactional
	public Dog updateDog(Dog theDog) throws ResourceNotFoundException {
 		return dogDAO.edit(theDog);
	}

	@Override
	@Transactional
	public Dog deleteDog(int theId) throws ResourceNotFoundException {
		return dogDAO.delete(theId);
	}

}





