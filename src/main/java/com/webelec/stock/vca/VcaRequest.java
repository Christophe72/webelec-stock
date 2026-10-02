package com.webelec.stock.vca;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record VcaRequest(

        @NotBlank
        @Size(max = 150)
        String candidateName,

        @NotBlank
        @Size(max = 150)
        String company,

        @NotNull
        VcaNiveau niveau,

        @NotNull
        LocalDate examDate,

        @Size(max = 150)
        String examCenter,

        @Min(0) @Max(100)
        Integer score,

        @NotNull
        VcaStatus status,

        @Size(max = 50)
        String certificateNumber,

        LocalDate expiryDate
) {}
