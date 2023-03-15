package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.mydata.entity.Itemsample

class MainActivity : AppCompatActivity() {
    private lateinit var rv_itemsample: RecyclerView
    private lateinit var adapter: RecyclerViewAdapter_Itemsample
    private lateinit var items: ArrayList<Itemsample>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_itemsample=findViewById(R.id.rv_itemsample)

        items = ArrayList<Itemsample>()


        rv_itemsample.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)

        rv_itemsample.adapter = RecyclerViewAdapter_Itemsample(
            items,
            object : RecyclerViewOnClickListener {
                //Обработчик щелчка на элементе списка
                override fun onClicked(idx: Int) {
                    //Вывод выбранного элемента
                    Log.d("mysamp","Вы выбрали: "+idx.toString()+" "+items[idx].Name+" ")
                }
            }
        )

        var i:Int
        for(i in 0..10) {

            items.add(Itemsample(i,"Kolya"))
        }

        (rv_itemsample.adapter)?.notifyDataSetChanged()

    }
}