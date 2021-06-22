package ch.postfinance.ccyp.praktik.bootstrap

import ch.postfinance.ccyp.praktik.domain.Application
import ch.postfinance.ccyp.praktik.domain.Employee
import ch.postfinance.ccyp.praktik.domain.Job
import ch.postfinance.ccyp.praktik.domain.Profile.*
import ch.postfinance.ccyp.praktik.repository.ApplicationRepository
import ch.postfinance.ccyp.praktik.repository.EmployeeRepository
import ch.postfinance.ccyp.praktik.repository.JobRepository
import io.quarkus.runtime.StartupEvent
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.event.Observes
import javax.inject.Inject
import javax.transaction.Transactional


@ApplicationScoped
class DemoDataGenerator {

    @Inject
    lateinit var employeeRepository: EmployeeRepository

    @Inject
    lateinit var jobRepository: JobRepository

    @Inject
    lateinit var applicationRepository: ApplicationRepository

    @Transactional
    fun generateDemoDate(@Observes startupEvent: StartupEvent) {

        val jobs: MutableList<Job> = mutableListOf(
            Job(APPL, "PF55"), // 0
            Job(APPL, "PF85"),
            Job(APPL, "I123"),
            Job(APPL, "CCYP"),
            Job(APPL, "ICT Academy"),
            Job(APPL, "Techlab"), // 5
            Job(SYS, "I321"),
            Job(SYS, "PF88"),
            Job(SYS, "CCYP"),
            Job(PIBS, "ICT Academy"), // 9
            Job(WAYUP, "CCYP"), // 10
        )

        jobRepository.persist(jobs)
        jobRepository.flush()

        val employees: MutableList<Employee> = mutableListOf(
            Employee("Treffen Arne", APPL), // 0
            Employee("Emery Guntur", APPL),
            Employee("Othmann Alwin", APPL),
            Employee("Wolf Heriberto", APPL),
            Employee("Hamnett Geoffroy", APPL),
            Employee("Maddie Mallorey", APPL)  ,
            Employee("Broderick Valther", SYS), // 6
            Employee("Broderick Valther", SYS),
            Employee("Caryll Dollfuss", SYS),
            Employee("Kolt Garrin", WAYUP), // 9
            Employee("Allicea Vala", PIBS), // 10
        )
        employeeRepository.persist(employees)

        val applications: MutableList<Application> = mutableListOf(
            Application(employees[0], jobs[0], 1, 1),
            Application(employees[0], jobs[1], 2, 2),
            Application(employees[0], jobs[2], 3, 3),

            Application(employees[1], jobs[0], 1, 2),
            Application(employees[1], jobs[1], 2, 2),
            Application(employees[1], jobs[2], 3, 1),

            Application(employees[2], jobs[3], 1, 2),
            Application(employees[2], jobs[4], 2, 3),

            Application(employees[3], jobs[4], 1, 2),
            Application(employees[3], jobs[0], 2, 4),
            Application(employees[4], jobs[4], 1, 1),
            Application(employees[4], jobs[5], 2, 1),

            Application(employees[5], jobs[1], 1, 3),
            Application(employees[5], jobs[3], 2, 1),
            Application(employees[5], jobs[2], 3, 4),

            Application(employees[6], jobs[6], 2, 1),
            Application(employees[6], jobs[7], 1, 2),
            Application(employees[6], jobs[8], 3, 3),

            Application(employees[7], jobs[7], 3, 3),
            Application(employees[7], jobs[6], 1, 2),
            Application(employees[7], jobs[8], 2, 1),

            Application(employees[8], jobs[7], 1, 2),
            Application(employees[8], jobs[8], 2, 2),

            Application(employees[10], jobs[9], 1, 1),

            Application(employees[9], jobs[10], 1, 1)
        )

        applicationRepository.persist(applications)

    }


}