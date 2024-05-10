package edu.personal.grailsfm.authservice.dto;

import jakarta.validation.constraints.NotBlank;

public record RoleResponseDto(
        @NotBlank(message = "Name is mandatory")
        String name,

        @NotBlank(message = "Description is mandatory")
        String description
) {
}
