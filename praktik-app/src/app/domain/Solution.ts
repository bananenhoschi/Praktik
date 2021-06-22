import {Employee} from "./Employee";
import {Application} from "./Application";
import {Job} from "./Job";

export interface Solution {

  applications: Application[]
  employees: Employee[]
  jobs: Job[]

}
