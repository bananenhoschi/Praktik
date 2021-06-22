import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Employee} from "../domain/Employee";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private employeesUri = 'http://localhost:8080/api/employees'

  constructor(private http: HttpClient) {
  }

  getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.employeesUri);
  }
}
