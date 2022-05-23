package com.rydni.lab5.controller;

import com.rydni.lab5.dto.SalariesDto;
import com.rydni.lab5.exception.ValidationException;
import com.rydni.lab5.service.SalariesService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salaries")
@AllArgsConstructor
@Log
public class SalariesController {

    private final SalariesService salariesService;

    @GetMapping("/findAll")
    public List<SalariesDto> findAllSalaries(){
        log.info("Handling find all salaries request");
        return salariesService.findAll();
    }

    @DeleteMapping("/delete/{worker_id}")
    public ResponseEntity<Void> deleteSalaries(@PathVariable Integer worker_id){
        log.info("Handling delete salary request: " + worker_id);
        salariesService.deleteSalary(worker_id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/save")
    public SalariesDto saveSalaries(@RequestBody SalariesDto salariesDto) throws ValidationException{
        log.info("Handling save salaries: " + salariesDto);
        return salariesService.saveSalary(salariesDto);
    }
}
