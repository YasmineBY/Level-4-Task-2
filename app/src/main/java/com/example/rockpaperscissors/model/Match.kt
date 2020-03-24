package com.example.rockpaperscissors.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "match_table")
data class Match (
    // Match ID


    // Choice player
    @ColumnInfo(name = "player_choice")
    var choicePlayer: String,

    // Choice computer
    @ColumnInfo(name = "computer_choice")
    var computerChoice: String,

    // Result
    @ColumnInfo(name = "match_result")
    var matchResult: String,

    // Date
    @ColumnInfo(name = "date_match")
    var matchDate: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null

): Parcelable
