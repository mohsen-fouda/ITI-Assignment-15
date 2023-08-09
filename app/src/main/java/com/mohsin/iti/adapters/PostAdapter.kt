package com.mohsin.iti.adapters;

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mohsin.iti.databinding.PostItemBinding
import com.mohsin.iti.models.PostModel
import com.mohsin.iti.ui.MoreActivity
import com.mohsin.iti.utils.Const


class PostAdapter() :
    RecyclerView.Adapter<PostAdapter.Holder>() {

    var list: ArrayList<PostModel>? = null
    private val context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = PostItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = list?.get(position)!!
        holder.binding.apply {
            data.apply {
                uName.text = userName
                theDate.text = date
                PostContent.text = post
                Glide.with(holder.itemView.context).load(data.imgUrl)
                    .apply(RequestOptions.centerCropTransform())
                    .into(imgView)
            }

            Readbtn.setOnClickListener {
                val intent = Intent(holder.itemView.context, MoreActivity::class.java)
                intent.putExtra(Const.USERNAME, data.userName)
                intent.putExtra(Const.POST, data.post)
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    inner class Holder constructor(val binding: PostItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}


