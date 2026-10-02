package com.webelec.stock.chantier;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ChantierRequest(

        @NotBlank
        @Size(max = 150)
        String name,

        @NotBlank
        @Size(max = 255)
        String address,

        LocalDate startDate,

        LocalDate endDate,

        @NotNull
        ChantierStatus status
) {}
