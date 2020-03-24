package com.example.rockpaperscissors.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rockpaperscissors.R
import com.example.rockpaperscissors.model.Match
import kotlinx.android.synthetic.main.item_match.view.*

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
            itemView.txtDate.text = match.matchDate
            itemView.txtResult.text = match.matchResult
        }
    }
}
