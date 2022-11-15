package com.sesac.planet.data.model.mypage

import androidx.annotation.Keep

@Keep
data class CurrentUserInfoResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
)