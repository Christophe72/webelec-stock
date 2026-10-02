package com.webelec.stock.product;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record ProductRequest(

        @NotBlank
        @Size(max = 50)
        String reference,

        @NotBlank
        @Size(max = 100)
        String name,

        @NotNull
        @Min(0)
        Integer quantity,

        @NotNull
        @DecimalMin("0.01")
        BigDecimal price
) {}
