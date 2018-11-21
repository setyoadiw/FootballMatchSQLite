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
import kotlinx.android.synthetic.main.fragment_next_event.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FragmentNextEvent : Fragment() , MainView {


    lateinit var presenter : FootballPresenterImp

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        initPresenter()
        initView()

        return inflater.inflate(R.layout.fragment_next_event, container, false)
    }

    private fun initPresenter() {
        presenter = FootballPresenterImp(this)

    }

    private fun initView() {
        presenter.getDataNextEvents()

    }

    private fun partItemClicked(partItem : EventsItem) {

        //        startActivity<DetailActivity>(
        //                "id" to "${it.eventId}",
        //                "idhome" to "${it.idHome}",
        //                "idaway" to "${it.idAway}"
        //        )

        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra("dataParcel",partItem)
        startActivity(intent)


    }


    override fun berhasil(data: ArrayList<EventsItem>) {

    }

    override fun berhasilNextEvent(data: ArrayList<EventsItem>) {

        //masukkan ke adapter
        var NextEventAdapter = FootballAdapter(requireContext(), data, { partItem: EventsItem -> partItemClicked(partItem) })
        //adapter masukkan ke recyclerview
        recyclerview2.adapter = NextEventAdapter
        recyclerview2.layoutManager = LinearLayoutManager(requireContext())

    }

    override fun gagal(pesan: String) {

    }

    companion object {
        fun newInstance(): FragmentNextEvent {
            val fragment = FragmentNextEvent()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }


}
