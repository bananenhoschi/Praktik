package ch.postfinance.ccyp.praktik.repository

import ch.postfinance.ccyp.praktik.domain.Employee
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class EmployeeRepository: PanacheRepository<Employee> {
}