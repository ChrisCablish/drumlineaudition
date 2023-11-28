package com.example.drumlineaudition.controller;

import com.example.drumlineaudition.model.Attribute;
import com.example.drumlineaudition.model.Auditionee;
import com.example.drumlineaudition.model.NoteEntry;
import com.example.drumlineaudition.service.AuditioneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AuditioneeController {

    @Autowired
    private AuditioneeService auditioneeService;

    @GetMapping("/auditionees")
    public String listAuditionees(Model model) {
        model.addAttribute("auditionees", auditioneeService.getAllAuditionees());

        Map<Long, Attribute> attributes = new HashMap<>();
        attributes.put(1L, new Attribute("Technique"));
        attributes.put(2L, new Attribute("Sound Quality"));
        attributes.put(3L, new Attribute("Accuracy"));
        attributes.put(4L, new Attribute("Posture"));
        attributes.put(5L, new Attribute("Attitude"));
        attributes.put(6L, new Attribute("Preparedness"));




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
        model.addAttribute("notes",auditionee.getNotes());
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

    @GetMapping("individual/{id}/addnoteentry")
    public String addNoteEntry( Model model, @PathVariable Long id) {
        Auditionee auditionee = auditioneeService.getAuditioneeById(id);
        model.addAttribute("auditionee", auditionee);
        return "addnoteentry";
    }

    @PostMapping("individual/{id}/addnoteentry")
    public String processNoteEntry (@ModelAttribute NoteEntry noteEntry, @PathVariable Long id) {
        Auditionee auditionee = auditioneeService.getAuditioneeById(id);
        List<NoteEntry> noteList = auditionee.getNotes();
        if (noteList == null) {
            noteList = new ArrayList<>();
        }

        noteList.add(noteEntry);
        auditionee.setNotes(noteList);
        auditioneeService.saveAuditionee(auditionee);
        return "redirect:/individual/" + id;
    }


    @GetMapping("dashboard")
    public String displayDashboard(Model model) {
        List<String> pages = new ArrayList<>();
        pages.add("User Creation");
        pages.add("Adjust Role Permissions");
        pages.add("Workflow Management");
        List<String> user = new ArrayList<>();
        user.add("Manufacturing Operator");
        user.add("Product Manager");
        user.add("Administrator");
        model.addAttribute("pages",pages);
        model.addAttribute("user", user);
        return "dashboard";
    }

}
