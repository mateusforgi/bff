package com.example.bff.api

import com.example.bff.constant.GET_TIMELINE
import com.example.bff.dto.TimelineItemDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(value = "timeline", url = "https://5ef80ec4d6ce6d00163c7fd5.mockapi.io/api/v1")
interface TimelineAPI {

    @GetMapping(GET_TIMELINE)
    fun getTimeline(@PathVariable cpf: String): List<TimelineItemDTO>
}
