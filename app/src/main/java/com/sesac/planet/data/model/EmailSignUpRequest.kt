package com.sesac.planet.data.model

data class EmailSignUpRequest(
    val email: String,
    val password: String,
    val phone_num: String = "010-0000-0000",
    val user_name: String
)