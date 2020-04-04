package com.talentoMobile.noEstasSolo.features.authentication.usescases

import com.talentoMobile.noEstasSolo.core.functional.FirebaseCallback
import com.talentoMobile.noEstasSolo.core.interactor.UseCaseListener
import com.talentoMobile.noEstasSolo.features.user.models.UserEntity

class DoLogin(private val authenticationRepository: AuthenticationRepository) :
    UseCaseListener<DoLogin.Params>() {

    override suspend fun run(params: Params) =
        authenticationRepository.doLogin(params.user, params.firebaseCallback)

    class Params(val user: UserEntity, val firebaseCallback: FirebaseCallback)

}