import {Component, Input, OnInit} from '@angular/core';
import {Job} from "../domain/Job";

@Component({
  selector: 'app-job',
  templateUrl: './job.component.html',
  styleUrls: ['./job.component.css']
})
export class JobComponent implements OnInit {

  @Input() job?: Job

  constructor() {
  }

  ngOnInit(): void {
  }

}
