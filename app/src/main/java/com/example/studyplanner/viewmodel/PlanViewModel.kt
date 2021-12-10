package com.example.studyplanner.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.studyplanner.database.PlanDatabase
import com.example.studyplanner.database.PlanInput
import com.example.studyplanner.repository.PlanRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlanViewModel(application: Application) : AndroidViewModel(application){
    private val planDao = PlanDatabase.getDatabase(application).planDao()
    private val repository : PlanRepository

    val getAllPlan: LiveData<List<PlanInput>>

    init {
        repository = PlanRepository(planDao)
        getAllPlan = repository.getAllPlan()
    }

    fun insert(planInput: PlanInput){
        viewModelScope.launch(Dispatchers.IO){
            repository.insert(planInput)
        }
    }

    fun delete(planInput: PlanInput){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteItem(planInput)
        }
    }
    fun update(planInput: PlanInput){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateData(planInput)
        }
    }
    fun deleteAll(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAll()
        }
    }
    fun searchDatabase(searchQuery: String): LiveData<List<PlanInput>> {
        return repository.searchDatabase(searchQuery)
    }
}