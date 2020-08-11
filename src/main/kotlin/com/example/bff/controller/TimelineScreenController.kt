package com.example.bff.controller

import com.example.bff.constant.GET_TIMELINE_ENDPOINT_BFF
import com.example.bff.service.TimelineScreenService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class TimelineScreenController(private val screenTimelineService: TimelineScreenService) {
    @GetMapping(GET_TIMELINE_ENDPOINT_BFF)

    fun getFirstScreen(@PathVariable cpf: String,
                       @RequestParam offset: String) = screenTimelineService.createTimelineScreen(cpf, offset)
}