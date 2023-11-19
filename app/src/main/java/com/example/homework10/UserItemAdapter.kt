package com.example.homework10

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.homework10.databinding.UserInfoItemBinding

class UserItemAdapter(private val itemList:MutableList<UserItem>):RecyclerView.Adapter<UserItemAdapter.UserItemViewHolder>(){

    inner class UserItemViewHolder(private val binding:UserInfoItemBinding):RecyclerView.ViewHolder(binding.root){
        var icon = binding.itemIcon
        val arrow = binding.arrow
        val primaryText = binding.primaryText
        val secondaryText = binding.secondaryText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):UserItemViewHolder{
        return UserItemViewHolder(UserInfoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        val currentUser = itemList[position]
        holder.primaryText.text = currentUser.text
        holder.secondaryText.text = currentUser.optionalText
        val imageIcon = ContextCompat.getDrawable(holder.itemView.context, currentUser.icon)
        holder.icon.setImageDrawable(imageIcon)
        val arrowIcon = currentUser.arrow?.let { ContextCompat.getDrawable(holder.itemView.context, it) }
        holder.arrow.setImageDrawable(arrowIcon)
        if(currentUser.itemType == UserItemType.LOGOUT){
            holder.primaryText.setTextColor(Color.HSVToColor(floatArrayOf(0f, 0.64f, 1f)))
        }
    }
}