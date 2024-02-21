package com.teamsparta.demo111.domain.theater.repository

import com.teamsparta.demo111.domain.theater.dto.CreateTheaterRequest
import com.teamsparta.demo111.domain.theater.model.Theater
import org.springframework.data.jpa.repository.JpaRepository

interface TheaterRepository: JpaRepository <Theater, Long>{

}