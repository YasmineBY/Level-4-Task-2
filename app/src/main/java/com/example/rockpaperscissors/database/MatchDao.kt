package com.example.rockpaperscissors.database

import android.service.autofill.FieldClassification
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.rockpaperscissors.model.Match
import java.util.*

@Dao
interface MatchDao {

    @Query("SELECT * FROM match_table")
    suspend fun getAllMatches(): List<Match>

    @Insert
    suspend fun insertMatch(match: Match)

    @Delete
    suspend fun deleteMatch(match: Match)

    @Query("DELETE FROM match_table")
    suspend fun deleteAllMatches()




}

