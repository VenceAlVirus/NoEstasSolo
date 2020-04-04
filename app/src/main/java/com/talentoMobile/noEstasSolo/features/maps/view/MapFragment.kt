package com.talentoMobile.noEstasSolo.features.maps.view

import android.location.Location
import android.os.Bundle
import android.view.View
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.talentoMobile.noEstasSolo.R
import com.talentoMobile.noEstasSolo.core.extensions.Constants
import com.talentoMobile.noEstasSolo.core.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_map.*

class MapFragment : BaseFragment(), OnMapReadyCallback {
    override fun layoutId() = R.layout.fragment_map

    private lateinit var googleMap: GoogleMap

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(savedInstanceState)
    }

    private fun initView(savedInstanceState: Bundle?) {
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
        mapView.touchscreenBlocksFocus = false
    }

    override fun onMapReady(mGoogleMap: GoogleMap?) {
        if (mGoogleMap != null) {
            googleMap = mGoogleMap
            initMap()
        }
    }

    private fun initMap() {
        googleMap.uiSettings.isScrollGesturesEnabled = false
        googleMap.isMyLocationEnabled = false
        var location = LatLng(Constants.Maps.SPAIN_LATITUDE, Constants.Maps.SPAIN_LONGITUDE)
        var cameraPosition =
            CameraPosition.Builder().target(location).zoom(Constants.Maps.Zoom.STREETS).build()
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
    }
}