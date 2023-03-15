package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.example.myapplication.mydata.AppDatabase
import com.example.myapplication.mydata.entity.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Установить соединение с БД
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "mydb"
        ).allowMainThreadQueries().build()

        db.userDao().insertAll(User(null,"Вася",20,"vasya@mail.ru"))



        val user1_id = db.userDao().getAll().first().id;


        db.userDao().update(User(user1_id,"Коля",20,"kolya@mail.ru"))

        db.userDao().getAll().forEach {
            Log.d("myapp_log",it.id.toString()+" "+it.Name+" "+it.Age.toString()+" "+it.Email)
        }

        val user2_id = db.userDao().getAll().last().id;
        db.userDao().delete(User(user2_id,"",0,""))

        db.userDao().getAll().forEach {
            Log.d("myapp_log",it.id.toString()+" "+it.Name+" "+it.Age.toString()+" "+it.Email)
        }
    }
}