package com.setyo.kotlin.footballsqlite.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.setyo.kotlin.footballsqlite.adapter.FootballAdapter
import com.setyo.kotlin.footballsqlite.R
import com.setyo.kotlin.footballsqlite.activity.DetailActivity
import com.setyo.kotlin.footballsqlite.activity.MainView
import com.setyo.kotlin.footballsqlite.model.EventSchedule.EventsItem
import com.setyo.kotlin.footballsqlite.presenter.FootballPresenterImp
import kotlinx.android.synthetic.main.fragment_last_event.*

class FragmentMain : Fragment() , MainView {


    lateinit var presenter : FootballPresenterImp

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val fragmentView : View = inflater.inflate(R.layout.fragment_last_event, container, false)

        initPresenter()
        initView()

        return fragmentView
    }

    private fun initPresenter() {
        presenter = FootballPresenterImp(this)
    }

    private fun initView() {
        presenter.getDataLastEvents()

    }

    private fun partItemClicked(partItem : EventsItem) {

        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra("dataParcel",partItem)
        startActivity(intent)

    }

    override fun berhasil(data: ArrayList<EventsItem>) {
        //masukkan ke adapter
//        var LastEventAdapter = FootballAdapter(requireContext(),data)
        //adapter masukkan ke recyclerview

        recyclerview.layoutManager = LinearLayoutManager(requireContext())
//        recyclerview.adapter = LastEventAdapter

        recyclerview.adapter = FootballAdapter(requireContext(), data, { partItem: EventsItem -> partItemClicked(partItem) })

    }

    override fun berhasilNextEvent(data: ArrayList<EventsItem>) {

    }

    override fun gagal(pesan: String) {

    }


    companion object {
        fun newInstance(): FragmentMain {
            val fragment = FragmentMain()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }



}
