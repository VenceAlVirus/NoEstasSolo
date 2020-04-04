package com.talentoMobile.noEstasSolo.features.authentication.views.viewmodel

import androidx.lifecycle.MutableLiveData
import com.davidups.starwars.core.platform.BaseViewModel
import com.talentoMobile.noEstasSolo.core.exception.Failure
import com.talentoMobile.noEstasSolo.core.functional.FirebaseCallback
import com.talentoMobile.noEstasSolo.features.authentication.usescases.DoLogin
import com.talentoMobile.noEstasSolo.features.user.views.UserView

class LoginViewModel(private val doLogin: DoLogin) : BaseViewModel() {

    var notify: MutableLiveData<Any> = MutableLiveData()

    fun login(user: UserView) = doLogin(
        DoLogin.Params(user.toUser().toUserEntity(),
            object : FirebaseCallback {
                override fun onSuccess(result: Any) {
                    handleAddUser(result)
                }

                override fun onFailure(e: Exception) {
                    handleFailure(Failure.CustomError(0, e.message))
                }
            })
    )

    private fun handleAddUser(result: Any) {
        notify.value = result
    }
}