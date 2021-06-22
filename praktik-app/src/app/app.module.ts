import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {JobsComponent} from './jobs/jobs.component';
import {EmployeesComponent} from './employees/employees.component';
import {ApplicationsComponent} from './applications/applications.component';
import {JobComponent} from './job/job.component';
import {EmployeeComponent} from './employee/employee.component';
import {ApplicationComponent} from './application/application.component';
import {SolveComponent} from './solve/solve.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { ClarityModule } from '@clr/angular';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ClarityModule
  ],
  declarations: [AppComponent, JobsComponent, EmployeesComponent, ApplicationsComponent, JobComponent, EmployeeComponent, ApplicationComponent, SolveComponent],
  bootstrap: [AppComponent]
})
export class AppModule {
}
