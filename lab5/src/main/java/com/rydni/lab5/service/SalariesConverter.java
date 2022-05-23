package com.rydni.lab5.service;

import com.rydni.lab5.dto.SalariesDto;
import com.rydni.lab5.entity.Salaries;
import org.springframework.stereotype.Component;

@Component
public class SalariesConverter {

    public Salaries fromSalaryDtoToSalary(SalariesDto salariesDto) {
        Salaries salaries = new Salaries();
        salaries.setWorker_id(salariesDto.getWorker_id());
        salaries.setPosition(salariesDto.getPosition());
        salaries.setPayroll(salariesDto.getPayroll());
        return salaries;
    }

    public SalariesDto fromSalaryToSalaryDto(Salaries salaries) {
        return SalariesDto.builder()
                .worker_id(salaries.getWorker_id())
                .position(salaries.getPosition())
                .payroll(salaries.getPayroll())
                .build();
    }
}
