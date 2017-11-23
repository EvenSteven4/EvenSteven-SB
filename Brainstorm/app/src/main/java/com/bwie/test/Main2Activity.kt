package com.bwie.test

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.bwie.test.adapter.ListViewAdapter
import com.bwie.test.bean.DataBean
import com.bwie.test.bean.VideoBean
import com.bwie.test.pre.PreData
import com.bwie.test.view.IUserView
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() , IUserView {
    override fun VideoData(video: VideoBean) {
        Log.i("www",video.toString())
        AddVideoview(video.itemList!!)
    }

    override fun AddView(bean: List<DataBean>) {

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var p = PreData(this)
        //获取传过来的值
        p.getVideo(intent.getStringExtra("id"))



    }

    fun AddVideoview(list : List<VideoBean.ItemListBean>){
        var s = ListViewAdapter(this,list)
            listview.adapter = s

        listview!!.setOnItemClickListener{adapterView, view, i, l ->
                var intent = Intent()
                    intent.setClass(this,Main3Activity::class.java)
                    intent.putExtra("url",list.get(i)?.data?.playUrl)
                    startActivity(intent)
        }
    }

    //进行跳转页面传递值
    fun CuanInfo(){

    }


}
