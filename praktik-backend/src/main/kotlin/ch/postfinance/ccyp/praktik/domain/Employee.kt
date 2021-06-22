package ch.postfinance.ccyp.praktik.domain

import org.optaplanner.core.api.domain.lookup.PlanningId
import javax.persistence.*

@Entity
class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PlanningId
    var id: Long? = null

    @Column(nullable = false)
    lateinit var name: String

    @Column(nullable = false)
    lateinit var profile: Profile

    @OneToOne
    var job: Job? = null

    constructor(name: String, profile: Profile) {
        this.name = name
        this.profile = profile
    }

    constructor()


}