package com.bwie.test.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bwie.test.pre.BasePre

/**
 * Created by 1 on 2017/11/22.
 */
abstract class BaseActivity<V,P : BasePre<V>>(var p: P) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setCountView())
        getInit()
        p = getP()
       //p.attachView(this)
    }
    abstract fun setCountView():Int
    abstract  fun getInit()
    //得到P层的
    internal abstract  fun getP():P
}