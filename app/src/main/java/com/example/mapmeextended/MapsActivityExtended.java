package com.example.mapmeextended;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.maps.model.Dot;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mapmeextended.databinding.ActivityMapsExtendedBinding;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.Arrays;
import java.util.List;

public class MapsActivityExtended extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMarkerDragListener {

    private GoogleMap mMap;
    private ActivityMapsExtendedBinding binding;
    private Marker marker1,marker2,marker3,marker4;
    LatLng m1,m2,m3,m4;
    PolylineOptions polylineOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsExtendedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        // Add a marker in Sydney and move the camera
        m1 = new LatLng(10.0123,70.0123);
        m2 = new LatLng(20.0f, 70.0f);
        m3 = new LatLng(10.0f, 80.0f);
        m4 = new LatLng(20.0f, 80.0f);

        marker1 = mMap.addMarker(new MarkerOptions()
                .position(m1)
                .draggable(true)
                .title("Marker1 is Here!")
                .snippet("lat "+m1.latitude+" long "+m1.longitude)
        );
//        marker1.setSnippet("lat"+marker1.getPosition().latitude);
        marker2 = mMap.addMarker(new MarkerOptions()
                .position(m2)
                .draggable(true)
                .snippet("lat "+m2.latitude+" long "+m2.longitude)
                .title("Marker2 is Here!"));
        marker3 = mMap.addMarker(new MarkerOptions()
                .position(m3)
                .draggable(true)
                .snippet("lat "+m3.latitude+" long "+m3.longitude)
                .title("Marker3 is Here!"));
        marker4 = mMap.addMarker(new MarkerOptions()
                .position(m4)
                .draggable(true)
                .snippet("lat "+m4.latitude+" long "+m4.longitude)
                .title("Marker4 is Here!"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(m1));
        marker1.showInfoWindow();
        marker2.showInfoWindow();
        marker3.showInfoWindow();
        marker4.showInfoWindow();

        mMap.setOnInfoWindowClickListener(this);
        mMap.setOnMarkerDragListener(this);

        polylineOptions = new PolylineOptions()
                .add(m1)
                .add(m2)
                .add(m3)
                .add(m4)
                .color(Color.YELLOW)
                .zIndex(5)
                .width(10);

        Polyline polyline = mMap.addPolyline(polylineOptions);
        PolygonOptions polygonOptions = new PolygonOptions()
                .add(m1)
                .add(m2)
                .add(m3)
                .add(m4) //addHole(LatLong point1, LatLong point2,..`)
                .fillColor(Color.BLUE)
                .strokeWidth(20);

        Polygon polygon = mMap.addPolygon(polygonOptions);


        List<PatternItem> pattern = Arrays.asList(
                new Dot(),
                new Gap(10),
                new Dash(30)
        );

        CircleOptions circleOptions = new CircleOptions()
                .center(new LatLng(7.86,80.69))
                .radius(200000);//metres
        Circle circle = mMap.addCircle(circleOptions);
        circle.setStrokeColor(Color.MAGENTA);
        circle.setStrokePattern(pattern);
    }

//    @Override
    public void onInfoWindowClick(@NonNull Marker marker) {
        Toast.makeText(this, "Info Window is Clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMarkerDrag(@NonNull Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(@NonNull Marker marker) {
        marker.setSnippet(""+marker.getPosition());
        marker.showInfoWindow();
    }

    @Override
    public void onMarkerDragStart(@NonNull Marker marker) {

    }
}