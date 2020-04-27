package com.gridu.BEProgram;

import com.gridu.BEProgram.entities.Dog;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.validation.*;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DogValidationTest {
    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterClass
    public static void close() {
        validatorFactory.close();
    }

    @Test
    public void shouldFailOnEmptyDogName(){
        Dog dog = new Dog(1, "", "1999-08-08", Float.parseFloat("70"), Float.parseFloat("66"));

        Set<ConstraintViolation<Dog>> violations
                = validator.validate(dog);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void shouldFailOnIncorrectDogDateOfBirth(){
        Dog dog = new Dog(1, "Bim", "1999.08.08", Float.parseFloat("70"), Float.parseFloat("66"));

        Set<ConstraintViolation<Dog>> violations
                = validator.validate(dog);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void shouldFailOnNegativeDogWeight(){
        Dog dog = new Dog(1, "Bim", "1999-08-08", Float.parseFloat("70"), Float.parseFloat("-10"));

        Set<ConstraintViolation<Dog>> violations
                = validator.validate(dog);

        assertFalse(violations.isEmpty());
    }
    @Test
    public void shouldFailOnNegativeDogHeight(){
        Dog dog = new Dog(1, "Bim", "1999-08-08", Float.parseFloat("-70"), Float.parseFloat("10"));

        Set<ConstraintViolation<Dog>> violations
                = validator.validate(dog);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void shouldTrueOnCorrectDogData(){
        Dog dog = new Dog(1, "Bim", "1999-08-08", Float.parseFloat("70"), Float.parseFloat("10"));

        Set<ConstraintViolation<Dog>> violations
                = validator.validate(dog);

        assertTrue(violations.isEmpty());
    }
}
