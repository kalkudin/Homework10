package com.example.homework10

import android.content.ClipData.Item
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var userItemAdapter:UserItemAdapter
    private val userItemList = mutableListOf<UserItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUp()
    }

    private fun setUp(){
        initializeItemList()
        initializeItemListAdapter()
    }
    private fun initializeItemList(){
        userItemList.also{
            it.add(UserItem( R.drawable.item_profile_icon, R.drawable.arrow_right,"Edit Profile", "", itemType = UserItemType.NORMAL))
            it.add(UserItem( R.drawable.location_icon, R.drawable.arrow_right,"Adress", "", itemType = UserItemType.NORMAL))
            it.add(UserItem( R.drawable.notification_icon, R.drawable.arrow_right,"Notification", "", itemType = UserItemType.NORMAL))
            it.add(UserItem( R.drawable.wallet_icon, R.drawable.arrow_right,"Payment", "", itemType = UserItemType.NORMAL))
            it.add(UserItem( R.drawable.security_icon, R.drawable.arrow_right,"Security", "", itemType = UserItemType.NORMAL))
            it.add(UserItem( R.drawable.language_icon, R.drawable.arrow_right,"Language", "English (US)", itemType = UserItemType.NORMAL))
            it.add(UserItem( R.drawable.night_mode_icon, null,"Dark Mode", "", itemType = UserItemType.CHECKBOX))
            it.add(UserItem( R.drawable.lock_icon, R.drawable.arrow_right,"Privacy", "", itemType = UserItemType.NORMAL))
            it.add(UserItem( R.drawable.info_icon, R.drawable.arrow_right,"Help Center", "", itemType = UserItemType.NORMAL))
            it.add(UserItem( R.drawable.friends_icon, R.drawable.arrow_right,"Invite Friends", "", itemType = UserItemType.NORMAL))
            it.add(UserItem( R.drawable.logout_icon, null,"Logout", "", itemType = UserItemType.LOGOUT))
        }
    }
    private fun initializeItemListAdapter(){
        userItemAdapter = UserItemAdapter(userItemList)
        binding.userInfoItemRecycler.apply{
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = userItemAdapter
        }
    }
}