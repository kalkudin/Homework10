package com.example.homework10

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.homework10.databinding.UserInfoItemBinding
import com.example.homework10.databinding.UserLanguageItemBinding

class UserItemAdapter(private val itemList:MutableList<UserItem>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    inner class UserItemViewHolder(private val binding:UserInfoItemBinding):RecyclerView.ViewHolder(binding.root){
        var icon = binding.itemIcon
        val arrow = binding.arrow
        val primaryText = binding.primaryText
        val secondaryText = binding.secondaryText
    }
    inner class UserLanguageItemViewHolder(private val binding:UserLanguageItemBinding):RecyclerView.ViewHolder(binding.root){
        var icon = binding.itemIcon
        val primaryText = binding.primaryText
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):RecyclerView.ViewHolder{
        return when(viewType){
            UserItemType.CHECKBOX.ordinal -> UserLanguageItemViewHolder(UserLanguageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> UserItemViewHolder(UserInfoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is UserItemViewHolder -> {
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
            is UserLanguageItemViewHolder -> {
                val currentUser = itemList[position]
                holder.primaryText.text = currentUser.text
                val imageIcon = ContextCompat.getDrawable(holder.itemView.context, currentUser.icon)
                holder.icon.setImageDrawable(imageIcon)
            }
        }
    }
    override fun getItemCount(): Int {
        return itemList.size
    }
    override fun getItemViewType(position: Int): Int {
        return itemList[position].itemType.ordinal
    }
}