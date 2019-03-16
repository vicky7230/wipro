package com.vicky7230.wipro.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Row(

    @SerializedName("title")
    @Expose
    var title: String? = null,
    @SerializedName("description")
    @Expose
    var description: String? = null,
    @SerializedName("imageHref")
    @Expose
    var imageHref: Any? = null

)
