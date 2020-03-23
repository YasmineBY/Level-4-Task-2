package com.example.level4_task2.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.level4_task2.model.Match
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


    @Query("SELECT * FROM match_table WHERE date_match BETWEEN :from AND :to")
    fun findUsersBornBetweenDates(from: Date, to: Date): List<Match>

}


