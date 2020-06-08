package com.talentoMobile.noEstasSolo.features.user.models

import com.davidups.starwars.core.extensions.empty

data class UserEntity(
    var email: String?,
    var password: String?) {

    companion object {
        fun empty() = UserEntity(String.empty(), String.empty())
    }

    fun toUser() = User(email, password)

}