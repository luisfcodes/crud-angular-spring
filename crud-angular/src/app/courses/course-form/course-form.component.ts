import { Component } from '@angular/core';
import { NonNullableFormBuilder } from '@angular/forms';
import { CoursesService } from '../services/courses.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Location } from '@angular/common';

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.scss']
})
export class CourseFormComponent {
  
  form = this.formBuilder.group({
    name: [''],
    category: [''],
  });

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private service: CoursesService,
    private snackBar: MatSnackBar,
    private location: Location
  ) {}

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
