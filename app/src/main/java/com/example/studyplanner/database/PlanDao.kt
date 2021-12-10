package com.example.studyplanner.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PlanDao {

    @Insert
    suspend fun insert(plantInput: PlanInput)

    @Delete
    suspend fun delete(plantInput: PlanInput)

    @Update
    suspend fun update(plantInput: PlanInput)

    @Query("DELETE FROM plan_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM plan_table ORDER BY title DESC")
    fun getAllPlan(): LiveData<List<PlanInput>>

    @Query("select * from plan_table where title like :searchQuery order by title desc")
    fun searchDatabase(searchQuery: String): LiveData<List<PlanInput>>

}
