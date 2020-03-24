package com.example.rockpaperscissors.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rockpaperscissors.R
import com.example.rockpaperscissors.model.Match
import kotlinx.android.synthetic.main.content_match_history.*
import java.util.*

class MatchHistory : AppCompatActivity() {
    private val matches = arrayListOf<Match>()

    private val matchAdapter = MatchAdapter(matches)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_history)
        initViews()
    }

    private fun initViews() {
        // Initialize the recycler view with a linear layout manager, adapter
        rvMatchHistory.layoutManager = LinearLayoutManager(this@MatchHistory, RecyclerView.VERTICAL, false)
        rvMatchHistory.adapter = matchAdapter
        rvMatchHistory.addItemDecoration(DividerItemDecoration(this@MatchHistory, DividerItemDecoration.VERTICAL))
        matches.add(Match(
             choicePlayer = "Rcok",
            computerChoice = "Paper",
            matchResult = "Win",
            matchDate = Calendar.getInstance().time.toString()
        )
        )
        matchAdapter.notifyDataSetChanged()

    }

}
