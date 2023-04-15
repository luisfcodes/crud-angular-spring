package com.luis.dto.mapper;

import org.springframework.stereotype.Component;

import com.luis.dto.CourseDTO;
import com.luis.enums.Category;
import com.luis.model.Course;

@Component
public class CourseMapper {

  public CourseDTO toDTO(Course course) {
    if(course == null){
      return null;
    }
    return new CourseDTO(course.getId(), course.getName(), course.getCategory().getValue());
  }

  public Course toEntity(CourseDTO courseDTO){

    if(courseDTO == null){
      return null;
    }

    Course course = new Course();
    if(courseDTO._id() != null) {
      course.setId(courseDTO._id());
    }
    course.setName(courseDTO.name());
    course.setCategory(convertCategoryValue(courseDTO.category()));
    return course;
  }

  public Category convertCategoryValue(String value){
    if(value == null) {
      return null;
    }
    return switch (value) {
      case "Front-end" -> Category.FRONT_END;
      case "Back-end" -> Category.BACK_END;
      default -> throw new IllegalArgumentException("Categoria inválida: " + value);
    };
  }
}
