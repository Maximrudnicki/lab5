package com.rydni.lab5.controller;

import com.rydni.lab5.dto.WorkersDto;
import com.rydni.lab5.exception.ValidationException;
import com.rydni.lab5.service.WorkersService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
@AllArgsConstructor
@Log
public class WorkersController {

    private final WorkersService workersService;

    @PostMapping("/save")
    public WorkersDto saveWorkers(@RequestBody WorkersDto workersDto) throws ValidationException {
        log.info("Handling save workers: " + workersDto);
        return workersService.saveWorker(workersDto);
    }

    @GetMapping("/findAll")
    public List<WorkersDto> findAllWorkers() {
        log.info("Handling find all workers request");
        return workersService.findAll();
    }

    @GetMapping("/findByLogin")
    public WorkersDto findByLogin(@RequestParam String login) {
        log.info("Handling find by login request: " + login);
        return workersService.findByLogin(login);
    }

    @GetMapping("/findByName")
    public WorkersDto findByName(@RequestParam String name) {
        log.info("Handling find by name request: " + name);
        return workersService.findByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteWorkers(@PathVariable Integer id) {
        log.info("Handling delete worker request: " + id);
        workersService.deleteWorker(id);
        return ResponseEntity.ok().build();
    }
}

