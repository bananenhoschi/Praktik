import {Component, OnInit} from '@angular/core';
import {EmployeeService} from "../service/employee.service";
import {Employee} from "../domain/Employee";

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {

  employees: Employee[] = []

  constructor(private service: EmployeeService) {
  }

  ngOnInit(): void {
    this.service.getEmployees().subscribe(employees => this.employees = employees)
  }

}
