package com.rydni.lab5.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "salaries_table")
@Data
@NoArgsConstructor
public class Salaries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer worker_id;

    @Column
    private String position;

    @Column
    private Integer payroll;
}
