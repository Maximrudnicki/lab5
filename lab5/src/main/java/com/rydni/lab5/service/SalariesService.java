package com.rydni.lab5.service;

import com.rydni.lab5.dto.SalariesDto;
import com.rydni.lab5.exception.ValidationException;

import java.util.List;

public interface SalariesService {

    SalariesDto saveSalary(SalariesDto salariesDto) throws ValidationException;

    void deleteSalary(Integer worker_id);

    List<SalariesDto> findAll();
}
