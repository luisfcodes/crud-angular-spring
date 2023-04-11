import { Component } from '@angular/core';
import { Course } from '../model/course';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})
export class CoursesComponent {
  courses: Course[] = [
    {
      _id: 'sss',
      name: 'teste',
      category: 'front'
    }
  ]
  displayedColumns = ['name', 'category']


}
