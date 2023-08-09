package com.example.lab18.test3

import com.google.gson.annotations.SerializedName

data class UserListModel(
    var page: String,
    @SerializedName("per_page")
    var perPage: String,
    var total: String,
    @SerializedName("total_pages")
    var totalPage: String,
    var data: List<UserModel>
)