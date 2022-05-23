package com.rydni.lab5.service;

import com.rydni.lab5.dto.SalariesDto;
import com.rydni.lab5.entity.Salaries;
import com.rydni.lab5.exception.ValidationException;
import com.rydni.lab5.repository.SalariesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultSalariesService implements SalariesService{

    private final SalariesRepository salariesRepository;
    private final SalariesConverter salariesConverter;

    @Override
    public SalariesDto saveSalary(SalariesDto salariesDto) throws ValidationException {
        validateSalariesDto(salariesDto);
        Salaries savedSalaries = salariesRepository.save(salariesConverter.fromSalaryDtoToSalary(salariesDto));
        return salariesConverter.fromSalaryToSalaryDto(savedSalaries);
    }

    @Override
    public void deleteSalary(Integer worker_id) {
        salariesRepository.deleteById(worker_id);
    }

    @Override
    public List<SalariesDto> findAll() {
        return salariesRepository.findAll()
                .stream()
                .map(salariesConverter::fromSalaryToSalaryDto)
                .collect(Collectors.toList());
    }


    private void validateSalariesDto(SalariesDto salariesDto) throws ValidationException{
        if(isNull(salariesDto)){
            throw new ValidationException("Object user is null");
        }
    }
}
