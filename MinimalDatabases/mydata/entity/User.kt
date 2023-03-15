package com.example.myapplication.mydata.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="table_users")
data class User (
    @PrimaryKey(autoGenerate = true) var id: Int?,
    @ColumnInfo(name="first_name") var Name: String,
    var Age:Int,
    var Email: String?
)