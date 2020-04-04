package com.talentoMobile.noEstasSolo.features.authentication.usescases

import com.talentoMobile.noEstasSolo.core.functional.FirebaseCallback
import com.talentoMobile.noEstasSolo.core.platform.NetworkHandler
import com.talentoMobile.noEstasSolo.features.authentication.services.AuthenticationService
import com.talentoMobile.noEstasSolo.features.user.models.UserEntity
import java.lang.Exception

interface AuthenticationRepository {

    fun doLogin(user: UserEntity, firebaseCallback: FirebaseCallback)
    fun doRegistry(user: UserEntity, firebaseCallback: FirebaseCallback)

    class Network(
        private val networkHandler: NetworkHandler,
        private val service: AuthenticationService
    ) : AuthenticationRepository {

        override fun doLogin(user: UserEntity, firebaseCallback: FirebaseCallback) {
            return when (networkHandler.isConnected) {
                true -> {
                    service.login(user, firebaseCallback)
                }
                false, null -> {
                    firebaseCallback.onFailure(Exception("No conection"))
                }
            }
        }

        override fun doRegistry(user: UserEntity, firebaseCallback: FirebaseCallback) {
            return when (networkHandler.isConnected) {
                true -> {
                    service.registry(user, firebaseCallback)
                }
                false, null -> {
                    firebaseCallback.onFailure(Exception("No conection"))
                }
            }        }
    }
}