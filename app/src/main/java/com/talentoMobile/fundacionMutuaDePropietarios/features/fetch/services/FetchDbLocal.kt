package com.talentoMobile.fundacionMutuaDePropietarios.features.fetch.services

import com.talentoMobile.fundacionMutuaDePropietarios.features.fetch.models.FetchEntity

interface FetchDbLocal {
    fun getFetchDate(id: Int): FetchEntity
    fun addFetchDate(fetchEntity: FetchEntity): Any
}