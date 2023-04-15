package com.luis.dto.mapper;

import org.springframework.stereotype.Component;

import com.luis.dto.CourseDTO;
import com.luis.model.Course;

@Component
public class CourseMapper {

  public CourseDTO toDTO(Course course) {
    if(course == null){
      return null;
    }
    return new CourseDTO(course.getId(), course.getName(), course.getCategory());
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
    course.setCategory(courseDTO.category());
    course.setStatus("Active");;
    return course;
  }
}
