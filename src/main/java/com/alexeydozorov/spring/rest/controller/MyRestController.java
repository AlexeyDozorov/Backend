package com.alexeydozorov.spring.rest.controller;

import com.alexeydozorov.spring.rest.entity.Emploee;
import com.alexeydozorov.spring.rest.exeption_handling.NoSuchEmploeeException;
import com.alexeydozorov.spring.rest.service.EmploeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private EmploeeService emploeeService;

    @GetMapping("/employees")
    public List<Emploee> showAllEmploees() {
        return emploeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Emploee getEmploee(@PathVariable int id){
        Emploee emploee = emploeeService.getEmploee(id);
        if (emploee == null){
            throw new NoSuchEmploeeException("Работника с id = " + id + " не обнаружено в БД");
        }
        System.out.println(emploee);
        return emploee;
    }

    @PostMapping("/employees")
    public Emploee addNewEmploee(@RequestBody Emploee emploee){
        emploeeService.saveEmloee(emploee);
        return emploee;
    }

    @PutMapping("/employees")
    public Emploee updateEmploee(@RequestBody Emploee emploee){
        emploeeService.saveEmloee(emploee);

        return emploee;
    }

    @DeleteMapping ("/employees/{id}")
    public String deleteEmploee(@PathVariable int id){
        Emploee emploee = emploeeService.getEmploee(id);
        if (emploee == null){
            throw new NoSuchEmploeeException("Работника с id = " + id + " не обнаружено в БД");
        }
        emploeeService.deleteEmploee(id);
        return "Работник с id = " + id + " был удален";
    }
}
