package com.example.studyplanner.repository

import androidx.lifecycle.LiveData
import com.example.studyplanner.database.PlanDao
import com.example.studyplanner.database.PlanInput

class PlanRepository ( val planDao : PlanDao ){
    suspend fun insert(planInput: PlanInput) = planDao.insert(planInput)
    suspend fun updateData(planInput: PlanInput) = planDao.insert(planInput)
    suspend fun deleteItem(planInput: PlanInput) = planDao.insert(planInput)
    suspend fun deleteAll() {
        planDao.deleteAll()
    }

    fun getAllPlan() : LiveData<List<PlanInput>> = planDao.getAllPlan()

    fun getAllPriorityPlan() : LiveData<List<PlanInput>> = planDao.getAllPriorityPlan()

    fun searchDatabase(searchQuery: String): LiveData<List<PlanInput>> {
        return planDao.searchDatabase(searchQuery)
    }
}