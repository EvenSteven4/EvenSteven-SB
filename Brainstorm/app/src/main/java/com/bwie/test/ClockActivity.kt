package com.bwie.test

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.bwie.test.service.ClockService
import com.bwie.test.service.ClockService.Bind








class ClockActivity : AppCompatActivity() {

    private var bind: Bind? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val timeMillis = System.currentTimeMillis()
        setContentView(R.layout.activity_clock)
//        val currentTimeMillis = System.currentTimeMillis()
//        Log.i("qqq", (timeMillis - currentTimeMillis).toString())

        val conn = object : ServiceConnection {

            //解除绑定
            override fun onServiceDisconnected(name: ComponentName) {
                // TODO Auto-generated method stub

            }

            //IBinder 中间人
            //绑定成功
            override fun onServiceConnected(name: ComponentName, service: IBinder) {
                // TODO Auto-generated method stub
                bind = service as Bind
                bind!!.onstart()
                Log.i("TAG", "service")
                Thread(Runnable(function = {
                    Thread.sleep(5000)
                    bind!!.onstop()
                    val intent = Intent(this@ClockActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                })).start()
            }
        }

        val service = Intent(this@ClockActivity, ClockService::class.java)

//		startService(service);
        /**
         * 第一个参数: service  intent
         * 第二个参数: conn
         * 第三个参数: flags
         */
        //进行绑定
        bindService(service, conn, Context.BIND_AUTO_CREATE)

    }
}
