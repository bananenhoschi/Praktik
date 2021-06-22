package ch.postfinance.ccyp.praktik.domain

import javax.persistence.*

@Entity
class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    lateinit var profile: Profile

    @Column(nullable = false)
    lateinit var name: String

    constructor(profile: Profile, name: String) {
        this.profile = profile
        this.name = name
    }

    constructor()

    override fun toString(): String {
        return "$id-$profile"
    }

}