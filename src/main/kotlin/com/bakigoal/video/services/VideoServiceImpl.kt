package com.bakigoal.video.services

import com.bakigoal.video.domain.Video
import com.bakigoal.video.exception.VideoAlreadyExistsException
import com.bakigoal.video.exception.VideoNotFoundException
import com.bakigoal.video.repository.VideoRepository
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class VideoServiceImpl(val videoRepository: VideoRepository) : VideoService {

    override fun getVideo(name: String): Video {
        return videoRepository.findByName(name) ?: throw VideoNotFoundException(name)
    }

    override fun saveVideo(file: MultipartFile, name: String) {
        if (videoRepository.existsByName(name)) {
            throw VideoAlreadyExistsException(name)
        }
        val video = Video(name = name, data = file.bytes)
        videoRepository.save(video)
    }

    override fun getAllVideoNames() = videoRepository.getAllNames()
}