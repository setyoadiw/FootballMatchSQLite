package com.setyo.kotlin.footballsqlite.activity

import com.setyo.kotlin.footballsqlite.model.EventSchedule.EventsItem

interface MainView {

    fun berhasil(data: ArrayList<EventsItem>)
    fun berhasilNextEvent(data: ArrayList<EventsItem>)
    fun gagal(pesan : String)

}