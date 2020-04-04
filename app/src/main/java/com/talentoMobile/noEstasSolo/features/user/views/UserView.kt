package com.talentoMobile.noEstasSolo.features.user.views

import com.talentoMobile.noEstasSolo.features.user.models.User
import java.io.Serializable

data class UserView(
    var email: String?,
    var password: String?): Serializable {

    fun toUser() = User(email, password)

}