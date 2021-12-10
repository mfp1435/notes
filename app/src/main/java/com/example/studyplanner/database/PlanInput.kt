package com.example.studyplanner.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.sql.Date
import java.sql.Time

@Parcelize
@Entity(tableName = "plan_table")

data class PlanInput(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var description: String
) : Parcelable
