package com.talentoMobile.noEstasSolo.features.user.models

import com.talentoMobile.noEstasSolo.features.user.views.UserView

data class User(
    var email: String?,
    var password: String?) {

    fun toUserEntity() = UserEntity(email, password)
    fun toUserView() = UserView(email, password)
}