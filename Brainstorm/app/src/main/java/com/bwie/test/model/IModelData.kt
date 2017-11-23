package com.bwie.test.model

import com.bwie.test.bean.DataBean
import com.bwie.test.bean.VideoBean
import io.reactivex.Flowable

/**
 * Created by 1 on 2017/11/23.
 */
interface IModelData {
    fun getModleData(): Flowable<List<DataBean>>

    //获取视频的集合内容
    fun getModleVideos(name:String):Flowable<VideoBean>
}