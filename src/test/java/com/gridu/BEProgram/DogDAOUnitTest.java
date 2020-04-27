package com.gridu.BEProgram;

import com.gridu.BEProgram.DAOs.DogDAO;
import com.gridu.BEProgram.config.WebConfig;
import com.gridu.BEProgram.exceptions.ResourceNotFoundException;
import com.gridu.BEProgram.entities.Dog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class})
@WebAppConfiguration
public class DogDAOUnitTest {

    @Autowired
    @Qualifier(value="InMemory")
    private DogDAO dogDAO;

    Dog dog;

    @Before
    public void initDog(){
        dog = new Dog(null, "DogName1", "2000-01-10", Float.parseFloat("30"), Float.parseFloat("30"));
    }

    @Test
    @Transactional
    public void shouldAddDogToDB() throws ResourceNotFoundException {
        Dog expectedDog = dogDAO.add(dog);
        Integer id = expectedDog.getId();
        assertEquals("Record was added incorrect", expectedDog, dogDAO.getById(id));
    }

    @Test
    @Transactional
    public void shouldDeleteDogFromDB() throws ResourceNotFoundException {
        Dog expectedDog = dogDAO.add(dog);
        Integer id = expectedDog.getId();
        dogDAO.delete(id);

        assertFalse("Record wasn't deleted", dogDAO.allDogs().contains(expectedDog));
    }

    @Test
    @Transactional
    public void shouldUpdateDog() throws ResourceNotFoundException {
        Dog addedDog = dogDAO.add(dog);
        Integer id = addedDog.getId();
        addedDog.setName("DogName2");
        dogDAO.edit(addedDog);
        assertEquals("Record wasn't update", "DogName2", dogDAO.getById(id).getName());
    }


}
