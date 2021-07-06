package ch.postfinance.ccyp.praktik.domain

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty
import org.optaplanner.core.api.domain.solution.PlanningScore
import org.optaplanner.core.api.domain.solution.PlanningSolution
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore


@PlanningSolution
class PraktikSolution {


    @ValueRangeProvider(id = "jobRange")
    @ProblemFactCollectionProperty
    lateinit var jobs: List<Job>

    @PlanningEntityCollectionProperty
    lateinit var employees: List<Employee>

    @PlanningScore
    lateinit var score: HardSoftScore

    constructor(jobs: List<Job>, employees: List<Employee>) {
        this.employees = employees
        this.jobs = jobs
    }

    constructor() {}

}
