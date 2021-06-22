import {Component, Input, OnInit} from '@angular/core';
import {Application} from "../domain/Application";

@Component({
  selector: 'app-application',
  templateUrl: './application.component.html',
  styleUrls: ['./application.component.css']
})
export class ApplicationComponent implements OnInit {

  @Input() application?: Application
  @Input() match?: boolean

  constructor() {
  }

  ngOnInit(): void {
  }

}
