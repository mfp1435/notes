package com.example.studyplanner.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

class PlanDatabase {

    @Database(entities = arrayOf(PlanInput::class), version = 1, exportSchema = false)
    abstract class PlanDatabase : RoomDatabase() {
        abstract fun planDao(): PlanDao
        companion object {
            @Volatile
            private var INSTANCE: PlanDatabase? = null
            fun getDatabase(context: Context): PlanDatabase {
                synchronized(this) {
                    var instance = INSTANCE
                    if (instance == null) {
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            PlanDatabase::class.java,
                            "plan_database"
                        ).fallbackToDestructiveMigration()
                            .build()
                        INSTANCE = instance
                    }
                    return instance
                }
            }
        }
    }
}
