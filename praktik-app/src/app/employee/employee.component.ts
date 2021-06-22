import {Component, Input, OnInit} from '@angular/core';
import {Employee} from "../domain/Employee";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  @Input() employee?: Employee;

  profileShort: string | undefined;

  constructor() { }


  ngOnInit(): void {
    this.profileShort = this.employee?.profile?.charAt(0)
  }

}
