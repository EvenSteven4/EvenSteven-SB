package com.bwie.test.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bwie.test.R
import com.bwie.test.bean.VideoBean
import com.squareup.picasso.Picasso

/**
 * Created by 1 on 2017/11/23.
 */
class ListViewAdapter(var context: Context, var list: List<VideoBean.ItemListBean>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder :MyViewHolder
        var v : View
        if (convertView == null) {
            v = View.inflate(context, R.layout.listview, null)
            holder = MyViewHolder(v)
            v.tag = holder
        } else {
            v = convertView
            holder = v.tag as MyViewHolder
        }
        holder.textview.text = list.get(position).data?.title
        Picasso.with(context).load(list?.get(position)?.data?.tags?.get(0)?.headerImage).into(holder.image)

        return v

    }
    override fun getItem(p0: Int): Any = list.get(p0)
    override fun getItemId(p0: Int): Long = p0.toLong()
    override fun getCount(): Int = list.size

    class MyViewHolder( viewItem: View){
        var textview: TextView = viewItem.findViewById(R.id.video_tv)
        var image : ImageView = viewItem.findViewById(R.id.video)

    }


}