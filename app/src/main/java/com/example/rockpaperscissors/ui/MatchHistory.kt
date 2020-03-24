package com.example.rockpaperscissors.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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



const val RETURN_HOME = "RETURN_HOME"

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
        getMatchesFromDatabase()
    }

    private fun previousScreen(){


    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_history, menu)
        return true
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val resultIntent = Intent()

        return when (item.itemId) {
            R.id.action_delete_match_history -> {
                deleteAllMatches()
                true
            }
            R.id.action_return -> {
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
             true
             }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun deleteAllMatches() {
        mainScope.launch {
            val matchList = withContext(Dispatchers.IO) {
                matchRepository.deleteAllMatches()
            }
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



}
