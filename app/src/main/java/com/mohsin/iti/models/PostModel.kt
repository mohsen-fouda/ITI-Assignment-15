package com.mohsin.iti.models

data class PostModel(
    var userName: String?=null,
    var date: String,
    var post: String,
    val imgUrl: String
)