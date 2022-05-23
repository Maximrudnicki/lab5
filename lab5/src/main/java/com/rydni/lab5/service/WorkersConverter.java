package com.rydni.lab5.service;

import com.rydni.lab5.dto.WorkersDto;
import com.rydni.lab5.entity.Workers;
import org.springframework.stereotype.Component;

@Component
public class WorkersConverter {

    public Workers fromUserDtoToUser(WorkersDto workersDto) {
        Workers workers = new Workers();
        workers.setId(workersDto.getId());
        workers.setEmail(workersDto.getEmail());
        workers.setName(workersDto.getName());
        workers.setLogin(workersDto.getLogin());
        return workers;
    }

    public WorkersDto fromUserToUserDto(Workers workers) {
        return WorkersDto.builder()
                .id(workers.getId())
                .email(workers.getEmail())
                .login(workers.getLogin())
                .name(workers.getName())
                .build();
    }
}

