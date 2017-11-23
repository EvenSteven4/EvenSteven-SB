package com.bwie.test

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.widget.Toast
import com.bwie.test.adapter.RecycleVIewAdapter
import com.bwie.test.bean.DataBean
import com.bwie.test.bean.VideoBean
import com.bwie.test.pre.PreData
import com.bwie.test.view.IUserView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),IUserView{
    override fun VideoData(video: VideoBean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun AddView(bean: List<DataBean>) {
        Log.i("xxx",bean.toString())
            setAddView(bean)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var p = PreData(this)
        p.getDataUser()
    }
    fun  setAddView (list:List<DataBean>){
        recycleview.layoutManager = GridLayoutManager(this,2)
        var  s = RecycleVIewAdapter(this,list)
        recycleview.adapter = s
        s.setOnItemListenter(object : RecycleVIewAdapter.OnItemListenter{
            override fun itemclick(position: Int) {
                    showToast(list.get(position).name)
            }
        })
    }
    fun showToast(name : String){
        Toast.makeText(this,"点击了"+name, Toast.LENGTH_SHORT).show()
        //跳转页面
        var intent =  Intent()
        intent.setClass(this,Main2Activity::class.java)
        intent.putExtra("id",""+name)
        startActivity(intent)

    }

    //进行销毁
    override fun onDestroy() {
        super.onDestroy()

    }
}
