package com.rydni.lab5.service;

import com.rydni.lab5.dto.WorkersDto;
import com.rydni.lab5.exception.ValidationException;

import java.util.List;

public interface WorkersService {

    WorkersDto saveWorker(WorkersDto workersDto) throws ValidationException;

    void deleteWorker(Integer workerId);

    WorkersDto findByLogin(String login);

    WorkersDto findByName(String name);



    List<WorkersDto> findAll();
}

