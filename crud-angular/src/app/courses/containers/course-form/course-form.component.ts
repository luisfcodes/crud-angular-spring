import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder } from '@angular/forms';
import { CoursesService } from '../../services/courses.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Course } from '../../model/course';

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.scss']
})
export class CourseFormComponent implements OnInit {
  
  form = this.formBuilder.group({
    _id: [''],
    name: [''],
    category: [''],
  });

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private service: CoursesService,
    private snackBar: MatSnackBar,
    private location: Location,
    private activedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
      const course: Course = this.activedRoute.snapshot.data['course']
      this.form.setValue({
        _id: course._id,
        name: course.name,
        category: course.category
      })
  }

  onSubmit(){
    this.service.save(this.form.value).subscribe({
      next: () => {
        this.onSuccess()
        this.onCancel()
      },
      error: () => this.onError()
    })
  }

  onCancel(){
    this.location.back()
  }

  private onSuccess(){
    this.snackBar.open('Curso salvo com sucesso!', '', { duration: 3000 })
  }

  private onError(){
    this.snackBar.open('Erro ao Salvar Curso!', '', { duration: 3000 })
  }
}
