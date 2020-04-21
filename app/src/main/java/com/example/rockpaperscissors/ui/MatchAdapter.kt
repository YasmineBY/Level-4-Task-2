package com.example.rockpaperscissors.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rockpaperscissors.R
import com.example.rockpaperscissors.model.Match
import kotlinx.android.synthetic.main.item_match.*
import kotlinx.android.synthetic.main.item_match.view.*
import kotlinx.android.synthetic.main.item_match.view.historyCpuChoice
import kotlinx.android.synthetic.main.item_match.view.historyPlayerChoice

class MatchAdapter(private val matches: List<Match>) : RecyclerView.Adapter<MatchAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        )
    }

    override fun getItemCount(): Int = matches.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(matches[position])

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(match: Match) {
            itemView.txtResult.text = match.matchResult
            itemView.txtDate.text = match.matchDate
            when(match.choicePlayer) {
            "rock" ->   itemView.historyPlayerChoice.setImageResource(R.drawable.rock)
            "paper" ->   itemView.historyPlayerChoice.setImageResource(R.drawable.paper)
            "scissors" ->   itemView.historyPlayerChoice.setImageResource(R.drawable.scissors)
            }
            when(match.computerChoice){
                "rock" ->   itemView.historyCpuChoice.setImageResource(R.drawable.rock)
                "paper" ->   itemView.historyCpuChoice.setImageResource(R.drawable.paper)
                "scissors" ->   itemView.historyCpuChoice.setImageResource(R.drawable.scissors)
            }
        }
    }





}
