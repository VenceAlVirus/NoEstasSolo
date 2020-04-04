package com.talentoMobile.noEstasSolo.features.offerAndDemand.models

import java.io.Serializable

data class Product (var title: String, var status: String, var isProfesional: Boolean, var productType: String, var description: String): Serializable{
}