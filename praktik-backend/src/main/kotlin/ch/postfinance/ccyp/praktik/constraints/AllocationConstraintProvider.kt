package ch.postfinance.ccyp.praktik.constraints

import ch.postfinance.ccyp.praktik.domain.Application
import ch.postfinance.ccyp.praktik.domain.Employee
import ch.postfinance.ccyp.praktik.domain.Job
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore
import org.optaplanner.core.api.score.stream.Constraint
import org.optaplanner.core.api.score.stream.ConstraintFactory
import org.optaplanner.core.api.score.stream.ConstraintProvider
import org.optaplanner.core.api.score.stream.Joiners

class AllocationConstraintProvider : ConstraintProvider {

    override fun defineConstraints(constraintFactory: ConstraintFactory): Array<Constraint> {
        return arrayOf(
            jobConstraint(constraintFactory),
            profileConstraint(constraintFactory),
            applicationConstraint(constraintFactory)
        )
    }

    private fun applicationConstraint(constraintFactory: ConstraintFactory): Constraint {
        return constraintFactory.from(Application::class.java)
            .join(Employee::class.java)
            .join(Job::class.java)
            .penalize("application constraint", HardSoftScore.ONE_HARD)
    }

    private fun profileConstraint(constraintFactory: ConstraintFactory): Constraint {
        return constraintFactory.from(Employee::class.java)
            .join(Employee::class.java, Joiners.equal(Employee::profile))
            .penalize("profile constraint", HardSoftScore.ONE_HARD)
    }

    private fun jobConstraint(constraintFactory: ConstraintFactory): Constraint {
        return constraintFactory.fromUniquePair(Employee::class.java, Joiners.equal(Employee::job))
            .penalize("job constraint", HardSoftScore.ONE_HARD)
    }


}