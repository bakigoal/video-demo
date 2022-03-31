package com.bakigoal.video.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "A video with this name already exists")
class VideoAlreadyExistsException(name: String): RuntimeException("Video with name = $name already exists")