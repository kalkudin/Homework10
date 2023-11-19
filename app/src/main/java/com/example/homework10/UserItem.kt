package com.example.homework10

data class UserItem(
    val icon:Int,
    val arrow:Int?,
    val text:String,
    val optionalText:String?,
    val itemType: UserItemType
    ){}
enum class UserItemType{
    NORMAL,
    CHECKBOX,
    LOGOUT
}