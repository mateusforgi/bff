package com.example.bff.service

import com.example.bff.api.TimelineAPI
import com.example.bff.builder.TimelineScreenBuilder
import org.springframework.stereotype.Service

@Service
class TimelineScreenService(private var timelineAPI: TimelineAPI) {

    fun createTimelineScreen(cpf: String,
                             offset: String) = TimelineScreenBuilder(this.timelineAPI.getTimeline(cpf), offset)
}