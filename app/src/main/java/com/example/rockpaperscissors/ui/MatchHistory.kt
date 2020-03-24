package com.example.rockpaperscissors.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rockpaperscissors.R
import com.example.rockpaperscissors.database.MatchRepository
import com.example.rockpaperscissors.model.Match
import kotlinx.android.synthetic.main.content_match_history.*
import kotlinx.android.synthetic.main.item_match.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class MatchHistory : AppCompatActivity() {
    private val matches = arrayListOf<Match>()
    private val matchAdapter = MatchAdapter(matches)
    private val mainScope = CoroutineScope(Dispatchers.Main)
    private lateinit var matchRepository: MatchRepository


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
        matchRepository = MatchRepository(this)
        matchAdapter.notifyDataSetChanged()
        addMatch()
    }
    
    private fun addMatch() {
            mainScope.launch {
                val match = Match(
                    choicePlayer = "rock",
                    computerChoice = "scissors",
                    matchResult = "win",
                    matchDate = Calendar.getInstance().time.toString()
                )
                withContext(Dispatchers.IO) {
                    matchRepository.insertMatch(match)
                }
                getMatchesFromDatabase()
        }
    }


    private fun getMatchesFromDatabase() {
        mainScope.launch {
            val matchList = withContext(Dispatchers.IO) {
                matchRepository.getAllMatches()
            }
            this@MatchHistory.matches.clear()
            this@MatchHistory.matches.addAll(matchList)
            this@MatchHistory.matchAdapter.notifyDataSetChanged()
        }
    }
//    private fun newMatch() {
//
//        matches.add(Match(
//            choicePlayer = "rock",
//            computerChoice = "scissors",
//            matchResult = "win",
//            matchDate = Calendar.getInstance().time.toString()
//        ))
//    }
//    private fun newMatch2() {
//        matches.add(Match(
//            choicePlayer = "paper",
//            computerChoice = "paper",
//            matchResult = "draw",
//            matchDate = Calendar.getInstance().time.toString()
//        ))
//    }

}
