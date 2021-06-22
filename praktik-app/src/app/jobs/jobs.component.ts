import {Component, OnInit} from '@angular/core';
import {Job} from "../domain/Job";
import {JobService} from "../service/job.service";

@Component({
  selector: 'app-jobs',
  templateUrl: './jobs.component.html',
  styleUrls: ['./jobs.component.css']
})
export class JobsComponent implements OnInit {

  jobs: Job[] = []

  constructor(private service: JobService) {
  }

  ngOnInit(): void {
    this.service.getJobs().subscribe((jobs) => this.jobs = jobs)
  }

}
