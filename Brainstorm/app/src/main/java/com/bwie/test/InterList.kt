package com.bwie.test

/**
 * Created by 1 on 2017/11/22.
 */
interface InterList {
     //推荐接口
    interface tjView {
         /**
          * 网络请求结束
          */
         fun onNetFinished()

         /**
          * 网络故障
          */
         fun onNetError()

         /**
          * 无数据
          */
         fun onNoData()

         /**
          * 加载中
          */
         fun onLoading()
    }

    interface tjModle {

    }

    interface tjPre {

    }
}
