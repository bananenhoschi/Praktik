package ch.postfinance.ccyp.praktik.domain

import org.optaplanner.core.api.domain.entity.PlanningEntity
import org.optaplanner.core.api.domain.lookup.PlanningId
import org.optaplanner.core.api.domain.variable.PlanningVariable
import javax.persistence.*

@Entity
@PlanningEntity
class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PlanningId
    var id: Long? = null

    @Column(nullable = false)
    lateinit var name: String

    @Column(nullable = false)
    lateinit var profile: Profile
    
    @PlanningVariable(valueRangeProviderRefs = ["jobRange"])
    @OneToOne
    var job: Job? = null

    constructor(name: String, profile: Profile) {
        this.name = name
        this.profile = profile
    }

    constructor()


}
