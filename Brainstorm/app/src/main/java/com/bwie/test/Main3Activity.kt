package com.bwie.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
            //获取得到传递过来的信息
            //进行视频播放
            vid.setUp(intent.getStringExtra("url"),false," ")
    }
}
