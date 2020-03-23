package com.example.level4_task2.database

import android.content.Context
import com.example.level4_task2.model.Match


//todo this class

class MatchRepository(context: Context) {

    private val matchDao: MatchDao

    //todo Remove the : !!
    init {
        val database =
            MatchRoomDatabase.getDatabase(context)
        matchDao = database!!.matchDao()
    }

    suspend fun getAllMatches(): List<Match> = matchDao.getAllMatches()

    suspend fun insertMatch(match: Match) = matchDao.insertMatch(match)

    suspend fun deleteMatch(match: Match) = matchDao.deleteMatch(match)

    suspend fun deleteAllMatches() = matchDao.deleteAllMatches()

}
