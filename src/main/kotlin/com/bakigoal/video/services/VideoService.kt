package com.bakigoal.video.services

import com.bakigoal.video.domain.Video
import org.springframework.web.multipart.MultipartFile


interface VideoService {
    fun getVideo(name: String): Video

    fun saveVideo(file: MultipartFile, name: String)

    fun getAllVideoNames(): List<String>
}