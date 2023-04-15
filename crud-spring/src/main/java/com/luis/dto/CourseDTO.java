package com.luis.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CourseDTO(
  Long _id,
  @NotBlank @NotNull @Length(min = 5, max = 200) String name,
  @NotNull @Length(max = 10) @Pattern(regexp = "Back-end|Front-end") String category
) {
}
