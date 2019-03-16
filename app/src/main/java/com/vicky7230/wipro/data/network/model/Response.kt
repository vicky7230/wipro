package com.vicky7230.wipro.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("title")
    @Expose
    var title: String? = null,
    @SerializedName("rows")
    @Expose
    var rows: List<Row>? = null
)
