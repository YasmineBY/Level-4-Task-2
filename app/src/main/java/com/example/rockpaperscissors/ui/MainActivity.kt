package com.example.rockpaperscissors.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rockpaperscissors.R
import com.example.rockpaperscissors.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var playerChoice: String = "rock"
  private lateinit var binding: ActivityMainBinding



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
        computerPick()
    }
    private fun onPaperClick() {
        imgPlyrChoice.setImageResource(R.drawable.paper)
        computerPick()
    }
    private fun onScissorsClick() {
        imgPlyrChoice.setImageResource(R.drawable.scissors)
        computerPick()
    }


    private fun computerPick(){
        imgCpuChoice.setImageResource(R.drawable.paper)

//        val choice: Int = (1..3).random()
//        if(choice == 1) {
//            imgCpuChoice.setImageResource(R.drawable.paper)
//        }

    }

    private fun randomChoice() {

    }



    }


