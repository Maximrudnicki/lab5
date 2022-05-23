package com.rydni.lab5.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkersDto {

    private Integer id;
    private String name;
    private String login;
    private String email;
}
