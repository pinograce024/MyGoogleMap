package com.example.mygooglemap;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<LatLng> arrayList= new ArrayList<>();
    LatLng Philippines = new LatLng(12.3300, 122.4880);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        arrayList.add(Philippines);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
        } else if (mMap != null) {
            // Access to the location has been granted to the app.
            mMap.setMyLocationEnabled(true);
        }

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(15.8334, 120.5897);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Mary Grace's Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        //marker of urdaneta
        Marker m1 = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(15.980608693731682, 120.56065956620292))
                .anchor(0.5f, 0.5f)
                .title("LOCATION")
                .snippet("Urdanetas's Location"));


        mMap.addCircle(new CircleOptions()
                .center(new LatLng(15.8334, 120.5897))
                .radius(5000)
                .strokeWidth(10)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(128, 255, 0, 0)));

        //location of urdaneta
        mMap.addCircle(new CircleOptions()
                .center(new LatLng(15.980620369721564, 120.56062868579194))
                .radius(5000)
                .strokeWidth(10)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(128, 255, 0, 0)));

        mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(15.8334, 120.5897),
                        new LatLng(15.848545951830328, 120.58842958699513),
                        new LatLng(15.853830234676844, 120.59804262405096),
                        new LatLng(15.855811805065278, 120.60353578808287),
                        new LatLng(15.873975293016892, 120.6028491425789),
                        new LatLng(15.895108926931428, 120.59186281451508),
                        new LatLng(15.902703284601367, 120.58568300497919),
                        new LatLng(15.925484636442473, 120.57984651819527),
                        new LatLng(15.943641834183895, 120.58121980920326),
                        new LatLng(15.95321496764389, 120.57606996792333),
                        new LatLng(15.96377789463568, 120.5722934176514),
                        new LatLng(15.960261055498252, 120.55848282963274),
                        new LatLng(15.970045169185891, 120.55545149148276),
                        new LatLng(15.972126833825214, 120.5548740937399),
                        new LatLng(15.983665433330511, 120.55540066580899),
                        new LatLng(15.984081739654545, 120.55605023826969),
                        new LatLng(15.9818208763404, 120.5601459625006),
                        new LatLng(15.980608693731682, 120.56065956620292))


                .width(10)
                .color(Color.BLUE));





        enableMyLocation();
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
    }


    public void enableMyLocation() {

    }
}