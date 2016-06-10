package com.svalero.pc.loginbusiness;


        import android.app.Activity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.MapFragment;
        import com.google.android.gms.maps.model.BitmapDescriptorFactory;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.Marker;
        import com.google.android.gms.maps.model.MarkerOptions;

        import java.util.ArrayList;
        import java.util.HashMap;

public class MainActivity extends Activity
{
    private GoogleMap mMap;
    private ArrayList<MyMarker> mMyMarkersArray = new ArrayList<MyMarker>();
    private HashMap<Marker, MyMarker> mMarkersHashMap;
    private static final LatLng Madrid = new LatLng(40.4167754,-3.703790199);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the HashMap for Markers and MyMarker object
        mMarkersHashMap = new HashMap<Marker, MyMarker>();

        mMyMarkersArray.add(new MyMarker("Anita", "icon5", Double.parseDouble("41.64886959999999"), Double.parseDouble("-0.889742100000035")));
        //mMyMarkersArray.add(new MyMarker("United States", "icon2", Double.parseDouble("33.7266622"), Double.parseDouble("-87.1469829")));
        mMyMarkersArray.add(new MyMarker("Carlos", "icon5", Double.parseDouble("41.3850639"), Double.parseDouble("2.1734034999999494")));
        mMyMarkersArray.add(new MyMarker("Maria", "icon5", Double.parseDouble("37.3890924"), Double.parseDouble("-5.984458899999936")));
        mMyMarkersArray.add(new MyMarker("Norberto", "icon5", Double.parseDouble("41.9202247"), Double.parseDouble("-1.2578168999999662")));
        mMyMarkersArray.add(new MyMarker("Pepe Garcia", "icon6", Double.parseDouble("38.7222524"), Double.parseDouble("-9.139336599999979")));
        mMyMarkersArray.add(new MyMarker("Diego", "icon7", Double.parseDouble("51.1642292"), Double.parseDouble("10.4541194")));
        //mMyMarkersArray.add(new MyMarker("Atlantic Ocean", "icondefault", Double.parseDouble("-13.1294607"), Double.parseDouble("-19.9602353")));

        setUpMap();

        plotMarkers(mMyMarkersArray);
    }

    private void plotMarkers(ArrayList<MyMarker> markers)
    {
        if(markers.size() > 0)
        {
            for (MyMarker myMarker : markers)
            {

                // Create user marker with custom icon and other options
                MarkerOptions markerOption = new MarkerOptions().position(new LatLng(myMarker.getmLatitude(), myMarker.getmLongitude()));
                markerOption.icon(BitmapDescriptorFactory.fromResource(R.drawable.currentlocation_icon));

                Marker currentMarker = mMap.addMarker(markerOption);
                mMarkersHashMap.put(currentMarker, myMarker);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Madrid, 6));
                mMap.setInfoWindowAdapter(new MarkerInfoWindowAdapter());
            }
        }
    }

    private int manageMarkerIcon(String markerIcon)
    {
        if (markerIcon.equals("icon1"))
            return R.drawable.icon1;
        else if(markerIcon.equals("icon2"))
            return R.drawable.icon2;
        else if(markerIcon.equals("icon3"))
            return R.drawable.icon3;
        else if(markerIcon.equals("icon4"))
            return R.drawable.icon4;
        else if(markerIcon.equals("icon5"))
            return R.drawable.icon5;
        else if(markerIcon.equals("icon6"))
            return R.drawable.icon6;
        else if(markerIcon.equals("icon7"))
            return R.drawable.icon7;
        else
            return R.drawable.icondefault;
    }


    private void setUpMap()
    {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null)
        {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

            // Check if we were successful in obtaining the map.

            if (mMap != null)
            {
                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
                {
                    @Override
                    public boolean onMarkerClick(com.google.android.gms.maps.model.Marker marker)
                    {
                        marker.showInfoWindow();
                        return true;
                    }
                });
            }
            else
                Toast.makeText(getApplicationContext(), "Unable to create Maps", Toast.LENGTH_SHORT).show();
        }
    }

    public class MarkerInfoWindowAdapter implements GoogleMap.InfoWindowAdapter
    {
        public MarkerInfoWindowAdapter()
        {
        }

        @Override
        public View getInfoWindow(Marker marker)
        {
            return null;
        }

        @Override
        public View getInfoContents(Marker marker)
        {
            View v  = getLayoutInflater().inflate(R.layout.infowindow_layout, null);

            MyMarker myMarker = mMarkersHashMap.get(marker);

            ImageView markerIcon = (ImageView) v.findViewById(R.id.marker_icon);

            TextView markerLabel = (TextView)v.findViewById(R.id.marker_label);

            TextView anotherLabel = (TextView)v.findViewById(R.id.another_label);

            markerIcon.setImageResource(manageMarkerIcon(myMarker.getmIcon()));

            markerLabel.setText(myMarker.getmLabel());
            anotherLabel.setText("Empleado");

            return v;
        }
    }
}
