package com.example.drumlineaudition.controller;

import com.example.drumlineaudition.model.Auditionee;
import com.example.drumlineaudition.service.AuditioneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuditioneeController {

    @Autowired
    private AuditioneeService auditioneeService;

    @GetMapping("/auditionees")
    public String listAuditionees(Model model) {
        model.addAttribute("auditionees", auditioneeService.getAllAuditionees());
        return "auditionees";
    }

    @GetMapping("/create")
        public String createAuditioneeForm () {
            return "create";
        }


    @PostMapping("/auditionees/create")
    public String processCreateNewAuditionee(@ModelAttribute Auditionee auditionee) {
        auditioneeService.saveAuditionee(auditionee);
        return "redirect:/auditionees";
    }

    @GetMapping("/individual/{id}")
    public String showAuditioneeDetails(@PathVariable Long id, Model model) {
        Auditionee auditionee = auditioneeService.getAuditioneeById(id);
        model.addAttribute("auditionee", auditionee);
        return "individual"; // the name of your Thymeleaf template for individual details
    }

    //NAME EDIT
    @GetMapping("individual/{id}/editname")
    public String editName( Model model, @PathVariable Long id) {
        Auditionee auditionee = auditioneeService.getAuditioneeById(id);
        model.addAttribute("auditionee", auditionee);
        return "editname";
    }

    @PostMapping("individual/{id}/editname")
    public String processNameChange(@PathVariable Long id, @RequestParam("name") String newName) {
        Auditionee auditionee = auditioneeService.getAuditioneeById(id);
        auditionee.setName(newName); // Update the name
        auditioneeService.saveAuditionee(auditionee); // Save the updated object
        return "redirect:/auditionees"; // Redirect after submission
    }

    //RATING EDIT
    @GetMapping("individual/{id}/editrating")
    public String editRating( Model model, @PathVariable Long id) {
        Auditionee auditionee = auditioneeService.getAuditioneeById(id);
        model.addAttribute("auditionee", auditionee);
        return "editrating";
    }

    @PostMapping("individual/{id}/editrating")
    public String processRatingChange(@PathVariable Long id, @RequestParam("rating") int newRating) {
        Auditionee auditionee = auditioneeService.getAuditioneeById(id);
        auditionee.setRating(newRating);
        auditioneeService.saveAuditionee(auditionee);
        return "redirect:/auditionees";
    }

}
