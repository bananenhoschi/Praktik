package ch.postfinance.ccyp.praktik

import ch.postfinance.ccyp.praktik.domain.Application
import ch.postfinance.ccyp.praktik.domain.Employee
import ch.postfinance.ccyp.praktik.domain.Job
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class web {

    @Inject
    lateinit var service: Service

    @GET
    @Path("/jobs")
    fun allJobs(): List<Job> {
        return service.allJobs()
    }

    @GET
    @Path("/applications")
    fun allApplications(): List<Application> {
        return service.allApplications()
    }

    @GET
    @Path("/employees")
    fun allEmployees(): List<Employee> {
        return service.allEmployees()
    }

    @GET
    @Path("/solve")
    fun solve() {
        service.solve()
    }
}