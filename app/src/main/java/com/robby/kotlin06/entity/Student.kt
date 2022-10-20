package com.robby.kotlin06.entity

import com.google.gson.annotations.SerializedName

/**
 * @author Robby Tan
 */
data class Student(
    @SerializedName("id") val id: String,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("department") val department: String,
    @SerializedName("email") val email: String
)