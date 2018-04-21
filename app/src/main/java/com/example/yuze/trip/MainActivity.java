package com.example.yuze.trip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.TextureMapView;

public class MainActivity extends AppCompatActivity {

    private TextureMapView mMapView;
    private BaiduMap mBaiduMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        mMapView = (TextureMapView) findViewById(R.id.mTexturemap);//地图初始化
        mBaiduMap = mMapView.getMap();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    protected void onResume(){
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
        mMapView.onPause();
    }
}
