package com.rydni.lab5.repository;

import com.rydni.lab5.entity.Workers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkersRepository extends JpaRepository<Workers, Integer> {

    Workers findByLogin(String login);
    Workers findByName(String name);

}
