import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Job} from "../domain/Job";

@Injectable({
  providedIn: 'root'
})
export class JobService {

  private jobsUri = 'http://localhost:8080/api/jobs'

  constructor(private http: HttpClient) {
  }

  getJobs(): Observable<Job[]> {
    return this.http.get <Job[]>(this.jobsUri);
  }
}
