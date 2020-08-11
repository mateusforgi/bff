package com.example.bff.builder

import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.core.ServerDrivenComponent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.*
import br.com.zup.beagle.widget.ui.ListDirection
import br.com.zup.beagle.widget.ui.ListView
import br.com.zup.beagle.widget.ui.Text
import br.com.zup.beagle.widget.ui.TextAlignment
import com.example.bff.constant.API_DATE_FORMAT
import com.example.bff.constant.COUNTRY_CODE
import com.example.bff.constant.LANGUAGE
import com.example.bff.dto.TimelineItemDTO
import org.intellij.lang.annotations.Language
import java.text.DateFormat
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.time.ZoneId
import java.util.*

class TimelineScreenBuilder(private val data: List<TimelineItemDTO>,
                                   private  val offset: String): ScreenBuilder {

    override fun build() = Screen(
            navigationBar = NavigationBar(
                    title = "Timeline",
                    showBackButton = true
            ),
            child = ScrollView(
                    scrollDirection = ScrollAxis.VERTICAL,
                    children = getView()
            )
    )

    private  fun getView(): List<ServerDrivenComponent> {
        if (data.isEmpty()) {
            return getEmptyView()
        }
        return getTimeline()
    }

    private fun getEmptyView(): List<ServerDrivenComponent> {
        val text = StringBuilder().append("Você ainda não contratou empréstimos ")
                .appendCodePoint(0x1F629)
                .append("\nConfira a lista ofertas ")
                .appendCodePoint(0x1F609)

        return listOf(
                Text("").applyFlex(
                        flex = Flex(
                                size = Size(
                                        height = 200.unitReal()
                                )
                        )
                ),
                Text(text.toString(), alignment = TextAlignment.CENTER)
        )
    }

    private fun getTimeline() = listOf(
            ListView(rows = data.map(this::getTimelineItem), direction = ListDirection.VERTICAL)
    )

    private fun getTimelineItem(timeline: TimelineItemDTO): TimelineWidget {
        val locale = Locale(LANGUAGE, COUNTRY_CODE)
        val value = NumberFormat.getCurrencyInstance(locale).format(timeline.value)

        return TimelineWidget(
                description = StringBuilder()
                        .append(timeline.description)
                        .append(" ")
                        .appendCodePoint(0x1F911)
                        .appendCodePoint(0x1F4B0)
                        .toString(),
                value = value,
                date = ""
        )
    }

    @RegisterWidget
    data class TimelineWidget(val description: String, val value: String, val date: String) : Widget()
}