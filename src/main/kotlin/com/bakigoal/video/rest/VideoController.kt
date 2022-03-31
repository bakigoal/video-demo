package com.bakigoal.video.rest

import com.bakigoal.video.services.VideoService
import org.springframework.core.io.ByteArrayResource
import org.springframework.core.io.Resource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile


@RestController
@RequestMapping("video")
class VideoController(val videoService: VideoService) {

    @PostMapping
    fun saveVideo(
        @RequestParam("file") file: MultipartFile,
        @RequestParam("name") name: String
    ): ResponseEntity<String> {
        videoService.saveVideo(file, name)
        return ResponseEntity.ok("Video saved successfully.")
    }

    @GetMapping("{name}")
    fun getVideoByName(@PathVariable("name") name: String): ResponseEntity<Resource> {
        return ResponseEntity.ok(ByteArrayResource(videoService.getVideo(name).data!!))
    }

    @GetMapping("all")
    fun getAllVideoNames(): ResponseEntity<List<String>> {
        return ResponseEntity.ok(videoService.getAllVideoNames())
    }
}