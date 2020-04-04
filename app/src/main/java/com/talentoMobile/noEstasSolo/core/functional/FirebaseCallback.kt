package com.talentoMobile.noEstasSolo.core.functional

import java.lang.Exception

interface FirebaseCallback {
    fun onSuccess(result: Any)
    fun onFailure(e:Exception)
}