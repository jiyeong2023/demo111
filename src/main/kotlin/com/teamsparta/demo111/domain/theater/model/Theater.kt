package com.teamsparta.demo111.domain.theater.model

import jakarta.persistence.*
import org.springframework.data.jpa.domain.AbstractPersistable_.id

@Entity
@Table(name = "theater")
class Theater(
    @Column(name= "theater_name")
    val theaterName: String,

    @Column(name = "address")
    val address: String,


) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L
}