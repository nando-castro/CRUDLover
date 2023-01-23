package com.cars.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record CarDTO(
    @NotBlank @NotNull String modelo, 
    @NotBlank @NotNull String fabricante,
    @NotBlank @NotNull @Past String dataFabricacao, 
    @NotBlank @NotNull double valor,
    @NotBlank @NotNull int anoModelo) {
}
