package com.rydni.lab5.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SalariesDto {

    private Integer worker_id;
    private String position;
    private Integer payroll;
}
