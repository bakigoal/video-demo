package com.bakigoal.video.repository

import com.bakigoal.video.domain.Video
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface VideoRepository : JpaRepository<Video, Long> {

    fun findByName(name: String): Video?

    fun existsByName(name: String): Boolean

    @Query(nativeQuery = true, value = "SELECT name FROM video")
    fun getAllNames(): List<String>
}