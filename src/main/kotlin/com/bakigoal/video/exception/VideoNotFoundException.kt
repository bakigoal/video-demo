package com.bakigoal.video.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "A video with this name is not found")
class VideoNotFoundException(name: String): RuntimeException("No video is found with name = $name")