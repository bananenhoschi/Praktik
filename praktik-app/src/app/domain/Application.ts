import {Job} from "./Job";
import {Employee} from "./Employee";

export interface Application {

  id: number
  job: Job
  employee: Employee
  priorityEmployee: number
  priorityJob: number
  score?: number
  match: boolean

}
