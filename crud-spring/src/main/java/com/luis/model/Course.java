package com.luis.model;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.luis.enums.Category;
import com.luis.enums.Status;
import com.luis.enums.converters.CategoryConverter;
import com.luis.enums.converters.StatusConverter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@SQLDelete(sql = "UPDATE Course SET status = 'Inactive' WHERE id = ?")
@Where(clause = "status = 'Active'")
public class Course {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonProperty("_id")
  private Long id;

  @NotBlank
  @NotNull
  @Length(min = 5, max = 200)
  @Column(length = 200, nullable = false)
  private String name;

  @NotNull
  @Column(length = 10, nullable = false)
  @Convert(converter = CategoryConverter.class)
  private Category category;

  @NotNull
  @Convert(converter = StatusConverter.class)
  @Column(length = 10, nullable = false)
  private Status status = Status.ACTIVE;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  //@JoinColumn(name = "course_id")
  private List<Lesson> lessons = new ArrayList<>();
}
