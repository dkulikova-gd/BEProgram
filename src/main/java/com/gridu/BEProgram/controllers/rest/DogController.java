package com.gridu.BEProgram.controllers.rest;

import com.gridu.BEProgram.exceptions.ResourceNotFoundException;
import com.gridu.BEProgram.entities.Dog;
import com.gridu.BEProgram.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("rest")
@RequestMapping("/api/v1")
public class DogController {

    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    @ResponseBody
    public List<Dog> dogsList() {
        return dogService.showDogs();
    }

    @PostMapping("/dog")
    @ResponseBody
    public Dog createDog(@RequestBody Dog dog) {
        return dogService.createDog(dog);
    }

    @GetMapping("/dog/{id}")
    @ResponseBody
    public Dog getDog(@PathVariable int id) throws ResourceNotFoundException{
        return dogService.getDog(id);
    }

    @PutMapping("/dog")
    @ResponseBody
    public Dog updateDog(@RequestBody Dog dog) throws ResourceNotFoundException{
        return dogService.updateDog(dog);
    }

    @DeleteMapping("/dog/{id}")
    @ResponseBody
    public Dog deleteDog(@PathVariable int id) throws ResourceNotFoundException{
        return dogService.deleteDog(id);
    }
}