import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Application} from "../domain/Application";

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {

  private applicationsUri = 'http://localhost:8080/api/applications'

  constructor(private http: HttpClient) {
  }

  getApplications(): Observable<Application[]> {
    return this.http.get<Application[]>(this.applicationsUri);
  }
}
