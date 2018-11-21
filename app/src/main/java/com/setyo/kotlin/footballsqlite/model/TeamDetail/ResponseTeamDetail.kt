package com.setyo.kotlin.footballsqlite.model.TeamDetail


import com.google.gson.annotations.SerializedName


data class ResponseTeamDetail(

	@field:SerializedName("teams")
	val teams: List<TeamsItem?>? = null
)