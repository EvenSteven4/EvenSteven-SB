package com.bwie.test.model

import com.bwie.test.Api
import com.bwie.test.IntentService
import com.bwie.test.bean.DataBean
import com.bwie.test.bean.VideoBean
import com.bwie.test.utils.ApiRetrofit
import io.reactivex.Flowable

/**
 * Created by 1 on 2017/11/22.
 */
class ModelData : IModelData{

    //视频
    override fun getModleVideos(name :String):Flowable<VideoBean>{
        var  videoflow = ApiRetrofit.getInstance()
                                    .getClientApi(IntentService::class.java,Api.VIDEOS)
                                    .getVideo(name,"date","26868b32e808498db32fd51fb422d00175e179df","83")
            return videoflow
    }

    override fun getModleData(): Flowable<List<DataBean>> {
       var mod = ApiRetrofit.getInstance()
               .getClientApi(IntentService::class.java,Api.BASE_URL)
               .getData("26868b32e808498db32fd51fb422d00175e179df",83)
        return  mod
    }
}