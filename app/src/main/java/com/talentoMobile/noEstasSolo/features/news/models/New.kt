package com.talentoMobile.noEstasSolo.features.news.models

import java.io.Serializable

data class New(
    var title: String,
    var image: String,
    var date: String,
    var source: String,
    var detail: String
) : Serializable {
}