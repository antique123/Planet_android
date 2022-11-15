package com.sesac.planet.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class KeywordResponse(
    @SerializedName("result") val result: ResultKeyword
) : BaseResponse()

@Keep
data class ResultKeyword(
    @SerializedName("keyword_name") val keyword_name:String
)