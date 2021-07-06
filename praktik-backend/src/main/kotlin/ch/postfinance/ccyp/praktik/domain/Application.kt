package ch.postfinance.ccyp.praktik.domain

import org.optaplanner.core.api.domain.entity.PlanningEntity
import org.optaplanner.core.api.domain.variable.PlanningVariable
import javax.persistence.*

@Entity
class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @ManyToOne
    lateinit var employee: Employee

    @ManyToOne
    lateinit var job: Job

    var priorityEmployee: Int = 0

    var priorityJob: Int = 0

    var score: Int = 0

    constructor(employee: Employee, job: Job, priorityEmployee: Int, priorityJob: Int) {
        this.employee = employee
        this.job = job
        this.priorityEmployee = priorityEmployee
        this.priorityJob = priorityJob
    }

    constructor() {

    }
}
