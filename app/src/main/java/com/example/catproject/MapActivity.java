package com.example.catproject;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;
import java.util.ArrayList;


public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Markers markers = new Markers();
    public ArrayList<Marker> markersOnMap = new ArrayList<>();
    private ClusterManager<MyItem> mClusterManager;


    // 종류별(cafe, restaurant, cat) MarkerOptions 리스트를 관리하는 클래스
    public class Markers {
        public ArrayList<MarkerOptions> cafe = new ArrayList<>();
        public ArrayList<MarkerOptions> restaurant = new ArrayList<>();
        public ArrayList<MarkerOptions> cat = new ArrayList<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

    }

    public void clearMarkers() {
        // 맵에 있는 모든 마커 삭제
        for (int i = 0; i < markersOnMap.size(); i++) {
            markersOnMap.get(i).remove();
        }
        // 리스트에 있는 모든 마커 삭제
        markersOnMap.clear();
    }

    public void OnCafe(GoogleMap mMap) {
        for (int i = 0; i < markers.cafe.size(); i++) {
            // markers의 cafe 리스트에 있는 MarkerOptions를 사용해서 Marker를 생성하고 맵에 추가
            Marker marker = mMap.addMarker(markers.cafe.get(i));
            // 현재 맵에 생성된 마커들을 관리하는 리스트인 markersOnMap에 방금 생성한 마커를 추가
            markersOnMap.add(marker);
        }
    }

    public void OnRestaurant(GoogleMap mMap) {
        for (int i = 0; i < markers.restaurant.size(); i++) {
            Marker marker = mMap.addMarker(markers.restaurant.get(i));
            markersOnMap.add(marker);
        }
    }

    public void OnCat(GoogleMap mMap) {
        for (int i = 0; i < markers.cat.size(); i++) {
            Marker marker = mMap.addMarker(markers.cat.get(i));
            markersOnMap.add(marker);
        }
    }

    public void ShowAll(View v) {
        clearMarkers(); // 모든 마커 삭제
        OnCafe(mMap); // 카페 마커 맵에 추가
        OnRestaurant(mMap); // 식당 마커 맵에 추가
        OnCat(mMap); // 고양이 마커 맵에 추가
    }

    public void ShowCafe(View v) {
        clearMarkers();
        OnCafe(mMap);
    }

    public void ShowRestaurant(View v) {
        clearMarkers();
        OnRestaurant(mMap);
    }

    public void ShowCat(View v) {
        clearMarkers();
        OnCat(mMap);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;

        //이미지마커 크기 조절
        BitmapDrawable bitmapdraw=(BitmapDrawable)getResources().getDrawable(R.drawable.catimage);
        Bitmap b=bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, 130, 130, true);

        // MarkerOptions는 마커 객체를 생성하기 위한 정보를 담고 있는 객체
        MarkerOptions markerOptions = new MarkerOptions();
        LatLng BetterHearts = new LatLng(35.19214486984619, 128.0836292534386);
        markerOptions.position(BetterHearts);
        markerOptions.title("베럴하츠");
        markerOptions.snippet("동물 동반입장 가능 카페");

        // Marker는 맵에 표시된 마커 객체
        Marker marker = mMap.addMarker(markerOptions);
        MarkerOptions markerOptions2 = new MarkerOptions();
        LatLng Salong = new LatLng(35.19078194475406, 128.07301852645392);
        markerOptions2.position(Salong);
        markerOptions2.title("살롱드인사");
        markerOptions2.snippet("동물 동반입장 가능 식당");
        Marker marker2 = mMap.addMarker(markerOptions2);

        MarkerOptions markerOptions3 = new MarkerOptions();
        LatLng Dakdal = new LatLng(35.19861596124102, 128.07941348412592);
        markerOptions3.position(Dakdal);
        markerOptions3.title("닥달커피");
        markerOptions3.snippet("동물 동반입장 가능 카페");
        Marker marker3 = mMap.addMarker(markerOptions3);

        MarkerOptions markerOptions4 = new MarkerOptions();
        LatLng cat1 = new LatLng(35.16502677947403, 128.09800681110977);
        markerOptions4.position(cat1);
        markerOptions4.title("고양이");
        markerOptions4.snippet("고양이 다발지역");
        markerOptions4.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        Marker marker4 = mMap.addMarker(markerOptions4);

        MarkerOptions markerOptions5 = new MarkerOptions();
        LatLng cat2 = new LatLng(35.15781687304075, 128.10828503603966);
        markerOptions5.position(cat2);
        markerOptions5.title("고양이");
        markerOptions5.snippet("고양이 다발지역");
        markerOptions5.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        Marker marker5 = mMap.addMarker(markerOptions5);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BetterHearts, 10));

        // 생성한 마커 객체들을 리스트에 넣어서 관리
        markersOnMap.add(marker);
        markersOnMap.add(marker2);
        markersOnMap.add(marker3);
        markersOnMap.add(marker4);
        markersOnMap.add(marker5);

        //markers 리스트에 해당되는 조건에 맞추어 객체들을 넣어서 관리
        markers.cafe.add(markerOptions);
        markers.restaurant.add(markerOptions2);
        markers.cafe.add(markerOptions3);
        markers.cat.add(markerOptions4);
        markers.cat.add(markerOptions5);

        //마커 클러스터링 매니저
        mClusterManager = new ClusterManager<>(this, mMap);
        mMap.setOnCameraIdleListener(mClusterManager);
        mMap.setOnMarkerClickListener(mClusterManager);

        //함수 호출을 통해서 클러스터링 구현
        addItems();

    }



    private void addItems() {

        double jinjuLat = 35.18047279377855;
        double jinjuLng = 128.10874759761796;
        MyItem jinju = new MyItem(jinjuLat, jinjuLng,"진주시청", "진주시청");

        double aLat = 34.76055310755727;
        double aLng = 127.66222042459039;
        MyItem a = new MyItem(aLat, aLng,"a","");

        double bLat = 35.179222615126655;
        double bLng = 129.07556840370526;
        MyItem b = new MyItem(bLat, bLng,"b","");

        double cLat = 35.22814453199742;
        double cLng = 128.68174992460388;
        MyItem c = new MyItem(cLat, cLng,"c","");

        double dLat = 35.16152468121717;
        double dLng = 126.82972136253564;
        MyItem d = new MyItem(dLat, dLng,"d","");

        double eLat = 35.8246314936884;
        double eLng = 128.5505614476217;
        MyItem e = new MyItem(eLat, eLng,"e","");

        double fLat = 35.214006054457364;
        double fLng = 128.58104672423067;
        MyItem f = new MyItem(fLat, fLng,"f","");

        mClusterManager.addItem(jinju);
        mClusterManager.addItem(a);
        mClusterManager.addItem(b);
        mClusterManager.addItem(c);
        mClusterManager.addItem(d);
        mClusterManager.addItem(e);
        mClusterManager.addItem(f);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "위성지도");
        menu.add(0, 2, 0, "일반지도");
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case 1:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;
            case 2:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
        }
        return false;
    }

}