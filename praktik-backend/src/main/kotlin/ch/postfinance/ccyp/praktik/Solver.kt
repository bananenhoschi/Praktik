package ch.postfinance.ccyp.praktik

import ch.postfinance.ccyp.praktik.domain.Application
import ch.postfinance.ccyp.praktik.domain.Employee
import ch.postfinance.ccyp.praktik.domain.Job
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class Solver {


    fun solve(applications: List<Application>, jobs: List<Job>, employees: List<Employee>) {


        applications.forEach { application -> application.score = calculateMatchingScore(application) }

        val map = applications.map { it.employee to it }
        println(map)

    }

    private fun calculateMatchingScore(application: Application): Int {
        return 2 * application.priorityLearner + application.priorityPractice
    }


}