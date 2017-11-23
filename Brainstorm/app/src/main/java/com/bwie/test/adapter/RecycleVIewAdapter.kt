package com.bwie.test.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bwie.test.MainActivity
import com.bwie.test.R
import com.bwie.test.bean.DataBean
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*

/**
 * Created by 1 on 2017/11/22.
 */
class RecycleVIewAdapter(mcontext: MainActivity, list: List<DataBean>) : RecyclerView.Adapter<RecycleVIewAdapter.MyViewHolder>() {

    private var context : Context = mcontext;
    private var slist : List<DataBean> = list;

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val inflate = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return MyViewHolder(inflate)
    }
    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
       // holder?.tv2?.
        holder?.TextView?.text  = slist.get(position).name
        Picasso.with(context).load(slist.get(position).headerImage).into(holder?.ImageView)
        holder?.ImageView?.setOnClickListener{
            litener?.itemclick(position)
        }
    }
    override fun getItemCount(): Int = slist.size

    class MyViewHolder(itemview: View?) : RecyclerView.ViewHolder(itemview){
            var TextView = itemView!!.tv2
            var ImageView = itemView!!.image
    }
    //接口回掉进行添加点击事件
    interface OnItemListenter{
        fun itemclick(position: Int)
    }
    var litener:OnItemListenter? = null
    fun setOnItemListenter(litener:OnItemListenter ){
        this.litener=litener
    }


}