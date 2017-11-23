package com.bwie.test

import com.bwie.test.bean.DataBean
import com.bwie.test.bean.VideoBean
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by 1 on 2017/11/23.
 */
interface IntentService {

    @GET("categories")
     fun getData(@Query("udid") channelId:String,@Query("vc")  startNum:Int):Flowable<List<DataBean>>

    @GET("videos")
    fun getVideo(@Query("categoryName") name:String,@Query("strategy") strategy:String,@Query("udid") udid:String,@Query("vc") vc:String) :Flowable<VideoBean>
}