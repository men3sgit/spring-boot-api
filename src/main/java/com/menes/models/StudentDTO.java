package com.menes.models;

import java.time.LocalDate;

public record StudentDTO (
        Long id,
        String email,
        String name,
        Integer age,
        LocalDate dob
){
}
