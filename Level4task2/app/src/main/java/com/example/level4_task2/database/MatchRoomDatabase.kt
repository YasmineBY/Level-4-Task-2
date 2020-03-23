package com.example.level4_task2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.level4_task2.model.Match

@Database(entities = [Match::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class MatchRoomDatabase : RoomDatabase() {


    abstract fun matchDao(): MatchDao
    companion object {
    private const val DATABASE_NAME = "MATCH_DATABASE"

    @Volatile
    private var matchRoomDatabaseInstance: MatchRoomDatabase? = null


        fun getDatabase(context: Context): MatchRoomDatabase? {
        if (matchRoomDatabaseInstance == null) {
            synchronized(MatchRoomDatabase::class.java) {
                if (matchRoomDatabaseInstance == null) {
                    matchRoomDatabaseInstance =
                        Room.databaseBuilder(context.applicationContext,
                            MatchRoomDatabase::class.java,
                            DATABASE_NAME
                        ).build()
                }

            }
        }
            return matchRoomDatabaseInstance
        }
    }

}



