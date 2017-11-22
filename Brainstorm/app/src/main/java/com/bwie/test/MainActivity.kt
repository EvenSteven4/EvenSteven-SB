package com.bwie.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import com.bwie.test.adapter.RecycleVIewAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //添加请求数据
        var list = ArrayList<String>()
        list.add("1236")
        list.add("qwqw")
        list.add("asda")
        list.add("hjyn")

        AddView(list)
    }
    fun  AddView (list:ArrayList<String>){
        recycleview.layoutManager = GridLayoutManager(this,2)
        var  s = RecycleVIewAdapter(this,list)
        recycleview.adapter = s

        s.setOnItemListenter(object : RecycleVIewAdapter.OnItemListenter{
            override fun itemclick(position: Int) {
                    showToast(position)
            }

        })
    }

    fun showToast(position : Int){
        Toast.makeText(this,"点击了"+position, Toast.LENGTH_SHORT).show()

    }
}
