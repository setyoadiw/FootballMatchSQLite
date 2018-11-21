package com.setyo.kotlin.footballsqlite.model.EventSchedule


import com.google.gson.annotations.SerializedName


data class ResponseLastEvents(

	@field:SerializedName("events")
	val events: List<EventsItem?>? = null
)