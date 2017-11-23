package com.bwie.test.view

import com.bwie.test.bean.DataBean
import com.bwie.test.bean.VideoBean

/**
 * Created by 1 on 2017/11/23.
 */
interface IUserView {
    fun AddView(bean: List<DataBean>)
    fun VideoData(video : VideoBean)
}