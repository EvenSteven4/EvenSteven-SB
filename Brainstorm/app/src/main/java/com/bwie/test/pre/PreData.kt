package com.bwie.test.pre

import com.bwie.test.bean.DataBean
import com.bwie.test.bean.VideoBean
import com.bwie.test.model.IModelData
import com.bwie.test.model.ModelData
import com.bwie.test.view.IUserView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by 1 on 2017/11/22.
 */
class PreData:IPre {


    var userview : IUserView?= null
     var usermodle : IModelData? = null

    constructor(userview: IUserView) {
        this.userview = userview
       usermodle = ModelData()
    }
    //操作得到数据
    override fun getDataUser() {
        var flow = usermodle!!.getModleData()
            flow?.subscribeOn(Schedulers.io())
                    ?.observeOn(AndroidSchedulers.mainThread())
                    ?.subscribe { s : List<DataBean> ->
                        userview?.AddView(s)
                    }
    }
    override fun getVideo(name: String) {
           var flow =  usermodle!!.getModleVideos(name)
                flow?.subscribeOn(Schedulers.io())
                        ?.observeOn(AndroidSchedulers.mainThread())
                        ?.subscribe{ videobean : VideoBean ->
                            userview?.VideoData(videobean)
                        }
    }

}