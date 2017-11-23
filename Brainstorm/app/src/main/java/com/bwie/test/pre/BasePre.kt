package com.bwie.test.pre

import java.lang.ref.WeakReference


/**
 * Created by 1 on 2017/11/22.
 */
abstract class BasePre<V> {

    public var weak : WeakReference<V>?=null

    //进行绑定view
    fun attachView(view : V){
        weak = WeakReference<V>(view)
    }
    //weak解除绑定
    fun dattchView(){
        if (weak != null) {
            weak!!.clear()
            weak = null
        }
    }

}