package com.rydni.lab5.service;

import com.rydni.lab5.dto.WorkersDto;
import com.rydni.lab5.entity.Workers;
import com.rydni.lab5.exception.ValidationException;
import com.rydni.lab5.repository.WorkersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultWorkersService implements WorkersService {

    private final WorkersRepository workersRepository;
    private final WorkersConverter workersConverter;


    @Override
    public WorkersDto saveWorker(WorkersDto workersDto) throws ValidationException {
        validateUserDto(workersDto);
        Workers savedWorker = workersRepository.save(workersConverter.fromUserDtoToUser(workersDto));
        return workersConverter.fromUserToUserDto(savedWorker);
    }

    private void validateUserDto(WorkersDto workersDto) throws ValidationException {
        if (isNull(workersDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(workersDto.getLogin()) || workersDto.getLogin().isEmpty()) {
            throw new ValidationException("Login is empty");
        }
    }

    @Override
    public void deleteWorker(Integer workerId) {
        workersRepository.deleteById(workerId);
    }

    @Override
    public WorkersDto findByLogin(String login) {
        Workers workers = workersRepository.findByLogin(login);
        if (workers != null) {
            return workersConverter.fromUserToUserDto(workers);
        }
        return null;
    }

    @Override
    public WorkersDto findByName(String name) {
        Workers workers = workersRepository.findByName(name);
        if (workers != null) {
            return workersConverter.fromUserToUserDto(workers);
        }
        return null;
    }

    @Override
    public List<WorkersDto> findAll() {
        return workersRepository.findAll()
                .stream()
                .map(workersConverter::fromUserToUserDto)
                .collect(Collectors.toList());
    }

}