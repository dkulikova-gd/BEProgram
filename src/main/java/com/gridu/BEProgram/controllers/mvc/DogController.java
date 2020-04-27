package com.gridu.BEProgram.controllers.mvc;

import com.gridu.BEProgram.entities.Dog;
import com.gridu.BEProgram.exceptions.ResourceNotFoundException;
import com.gridu.BEProgram.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class DogController {

    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public ModelAndView dogsList() {
        List<Dog> dogs = dogService.showDogs();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dogs");
        modelAndView.addObject("dogsList", dogs);
        return modelAndView;
    }


    @GetMapping("/add")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addPage");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addDog(@Valid @ModelAttribute("dog") Dog dog, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()){
            modelAndView.setViewName("addPage");
        } else {
            modelAndView.setViewName("redirect:/");
            dogService.createDog(dog);
        }
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editPage(@PathVariable int id) throws ResourceNotFoundException {
        Dog dog = dogService.getDog(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("dog", dog);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editDog(@Valid @ModelAttribute("dog") Dog dog, BindingResult bindingResult) throws ResourceNotFoundException {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()){
            modelAndView.setViewName("redirect:/edit/"+dog.getId());
        }
        else {
            dogService.updateDog(dog);
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteDog(@PathVariable int id) throws ResourceNotFoundException {
        ModelAndView modelAndView = new ModelAndView();
        dogService.deleteDog(id);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}