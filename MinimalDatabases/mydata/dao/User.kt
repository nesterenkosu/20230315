package com.example.myapplication.mydata

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.mydata.entity.User

@Dao
interface UserDao {
    @Insert
    fun insertAll(vararg user: User)

    @Query("SELECT * FROM table_users")
    fun getAll():List<User>

    @Update
    fun update(user:User)

    @Delete
    fun delete(user:User)
}