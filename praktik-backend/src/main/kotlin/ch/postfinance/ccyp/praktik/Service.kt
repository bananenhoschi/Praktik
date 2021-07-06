package ch.postfinance.ccyp.praktik

import ch.postfinance.ccyp.praktik.domain.Application
import ch.postfinance.ccyp.praktik.domain.Employee
import ch.postfinance.ccyp.praktik.domain.Job
import ch.postfinance.ccyp.praktik.domain.PraktikSolution
import ch.postfinance.ccyp.praktik.repository.ApplicationRepository
import ch.postfinance.ccyp.praktik.repository.EmployeeRepository
import ch.postfinance.ccyp.praktik.repository.JobRepository
import org.optaplanner.core.api.solver.SolverManager
import java.util.*
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.transaction.Transactional

@ApplicationScoped
class Service {

    var solutionId: Long = 1

    @Inject
    lateinit var employeeRepository: EmployeeRepository

    @Inject
    lateinit var jobRepository: JobRepository

    @Inject
    lateinit var applicationRepository: ApplicationRepository

    @Inject
    lateinit var solverManager: SolverManager<PraktikSolution, Long>

    fun allJobs(): List<Job> {
        return jobRepository.listAll()
    }

    fun allEmployees(): List<Employee> {
        return employeeRepository.listAll()
    }

    fun allApplications(): List<Application> {
        return applicationRepository.listAll()
    }

    @Transactional
    fun solve() {
        solverManager.solveAndListen(solutionId + 1, this::findById, this::save)
    }

    @Transactional
    fun findById(jobId: Long): PraktikSolution {
        return PraktikSolution(jobRepository.listAll(),  employeeRepository.listAll())
    }

    @Transactional
    fun save(solution: PraktikSolution) {
        for (employee in solution.employees) {
            val attachedEmplee: Employee = employeeRepository.findById(employee.id!!)!!
            attachedEmplee.job = employee.job
        }
    }

}
