package com.luis.dto;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.luis.model.Lesson;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CourseDTO(
  Long _id,
  @NotBlank @NotNull @Length(min = 5, max = 200) String name,
  @NotNull @Length(max = 10) @Pattern(regexp = "Back-end|Front-end") String category,
  List<Lesson> lessons) {
}
