import {Component, OnInit} from '@angular/core';
import {Application} from "../domain/Application";
import {ApplicationService} from "../service/application.service";

@Component({
  selector: 'app-applications',
  templateUrl: './applications.component.html',
  styleUrls: ['./applications.component.css']
})
export class ApplicationsComponent implements OnInit {

  applications: Application[] = []

  constructor(private service: ApplicationService) {
  }

  ngOnInit(): void {
    this.service.getApplications().subscribe((applications) => this.applications = applications)
  }

}
