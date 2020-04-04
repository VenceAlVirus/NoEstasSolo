package com.talentoMobile.noEstasSolo.core.navigation

import com.talentoMobile.noEstasSolo.core.functional.DialogCallback

interface PopUpDelegator {

    fun showErrorWithRetry(title: String, message: String, positiveText: String,
                           negativeText: String, callback: DialogCallback
    )
}