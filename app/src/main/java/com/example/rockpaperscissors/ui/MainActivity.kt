package com.example.rockpaperscissors.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.rockpaperscissors.R
import com.example.rockpaperscissors.database.MatchRepository
import com.example.rockpaperscissors.databinding.ActivityMainBinding
import com.example.rockpaperscissors.model.Match
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*


const val MATCH_HISTORY_REQUEST_CODE = 100

class MainActivity : AppCompatActivity() {
    private var playerChoice: String = "rock"
    private lateinit var binding: ActivityMainBinding
    private lateinit var matchRepository: MatchRepository
    private val mainScope = CoroutineScope(Dispatchers.Main)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {



        btnRock.setOnClickListener() {onRockClick() }
        btnPaper.setOnClickListener() { onPaperClick()}
        btnScissors.setOnClickListener() { onScissorsClick() }
    }

    private fun onRockClick() {
        imgPlyrChoice.setImageResource(R.drawable.rock)
        playerChoice = "rock"
        computerPick()
    }
    private fun onPaperClick() {
        imgPlyrChoice.setImageResource(R.drawable.paper)
        playerChoice = "paper"

        computerPick()
    }
    private fun onScissorsClick() {
        imgPlyrChoice.setImageResource(R.drawable.scissors)
        playerChoice = "scissors"
        computerPick()
    }


    private fun computerPick() {
        var computerChoice = " "
        var matchResult = " "
        var matchDate = " "

        val randompPick: Int = (1..3).random()


        if(randompPick == 1) {
            imgCpuChoice.setImageResource(R.drawable.rock)
            computerChoice = "rock"
                 if(playerChoice == "paper") {
                     matchResult = "win"
                 } else if (playerChoice == "rock"){
                     matchResult = "draw"
                 } else{
                     matchResult = "lose"
                 }
        }

        if(randompPick == 2) {
            imgCpuChoice.setImageResource(R.drawable.paper)
        }
        if(randompPick == 3) {
            imgCpuChoice.setImageResource(R.drawable.scissors)
        }


        mainScope.launch {
        val newMatch = Match (
            choicePlayer = playerChoice,
            computerChoice = computerChoice,
            matchResult = matchResult,
            matchDate = Calendar.getInstance().time.toString()
        )
            withContext(Dispatchers.IO) {
                matchRepository.insertMatch(newMatch)
            }

        }





    }










    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {


        R.id.action_view_match_history -> {
            startMatchHistory()
            true
        }
        else -> super.onOptionsItemSelected(item)

    }


    }

    private fun startMatchHistory() {
        val intent = Intent(this, MatchHistory::class.java)
        startActivityForResult(intent, MATCH_HISTORY_REQUEST_CODE)
    }


    }


