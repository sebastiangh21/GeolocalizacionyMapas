package com.sgh21.geolocalizacionymapas

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.sgh21.geolocalizacionymapas.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.mapType = GoogleMap.MAP_TYPE_NORMAL

        /*[6.248413462219099,-75.59152313699958],[6.245933820635618,-75.59659787645576],null,[6.247173642895783,-75.59406050672767],
        * 6.248733415116044,-75.59187182417152],[6.24625377504839,-75.5969465636277],null,[6.247493596550718,-75.59440919389961]*/
        // Add a marker in Sydney and move the camera
        val pampa1 = LatLng(6.247315,-75.594625)
        mMap.addMarker(MarkerOptions()
            .position(pampa1)
            .title("La Pampa Parrilla Argentina - Av Jardin - Restaurantes Medellin")
            .snippet("Musica en vivo")
        )

        val pampa2 = LatLng(6.246415,-75.597895)
        mMap.addMarker(MarkerOptions()
            .position(pampa2)
            .title("La Pampa Parrilla Argentina - Segundo parque Laureles- Restaurantes Medellin")
        )

        val pampa3 = LatLng(6.245619,-75.59261)
        mMap.addMarker(MarkerOptions()
            .position(pampa3)
            .title("La Pampa Parrilla Argentina (Laureles, Primer Parque)")
            .snippet("Musica en Vivo")
        )

        val pampa4 = LatLng(6.21756,-75.564775)
        mMap.addMarker(MarkerOptions()
            .position(pampa4)
            .title("La Pampa Parrilla Argentina (Laureles, Primer Parque)")
            .snippet("Musica en Vivo")
        )

        val pampa5 = LatLng(6.21747,-75.564675)
        mMap.addMarker(MarkerOptions()
            .position(pampa5)
            .title("La Pampa Argentina")
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pampa5, 12.5F))

        val pampa6 = LatLng(6.20812,-75.564665)
        mMap.addMarker(MarkerOptions()
            .position(pampa6)
            .title("La Pampa Parrilla Argentina (Provenza) - Restaurantes Medellin")
            .snippet("Musica en Vivo")
        )

        val pampa7 = LatLng(6.18414,-75.571939)
        mMap.addMarker(MarkerOptions()
            .position(pampa7)
            .title("La pampa parrillas argentina las palmas")
        )

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(this, "No tiene permisos de localizacion, por favor activarlos", Toast.LENGTH_SHORT).show()
            return
        }
        mMap.isMyLocationEnabled = true

    }
}