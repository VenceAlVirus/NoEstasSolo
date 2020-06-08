package com.talentoMobile.noEstasSolo.features.authentication.services

import com.davidups.starwars.core.extensions.empty
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.talentoMobile.noEstasSolo.core.extensions.Constants
import com.talentoMobile.noEstasSolo.core.functional.FirebaseCallback
import com.talentoMobile.noEstasSolo.features.user.models.UserEntity

class AuthenticationService(firebaseAuth: FirebaseAuth, firebaseFirestore: FirebaseFirestore) {

    val auth = firebaseAuth
    val database = firebaseFirestore.collection(Constants.FirebaseCollections.AUTHENTICATION)

    fun login(user: UserEntity, firebaseCallback: FirebaseCallback) {
        auth.signInWithEmailAndPassword(
                user.email ?: String.empty(),
                user.password ?: String.empty()
            )
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    auth.currentUser
                    firebaseCallback.onSuccess(Any())
                } else {
                    firebaseCallback.onFailure(Exception("registry error"))
                }
            }
    }

    fun registry(user: UserEntity, firebaseCallback: FirebaseCallback) {
        auth.createUserWithEmailAndPassword(
                user.email ?: String.empty(),
                user.password ?: String.empty()
            )
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    auth.currentUser
                    firebaseCallback.onSuccess(Any())
                } else {
                    firebaseCallback.onFailure(Exception("registry error"))
                }
            }

    }
}