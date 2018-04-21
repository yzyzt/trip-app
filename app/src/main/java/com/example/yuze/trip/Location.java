package com.example.yuze.trip;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.model.LatLng;

public class Location extends AppCompatActivity {
    public LocationClient mLocationClient = null;
    private MyLocationListener mListener = new MyLocationListener();
    static final String TAG = "location";


    public void onCreate(){
        mLocationClient = new LocationClient(getApplicationContext());//声明LocationClient
        mLocationClient.registerLocationListener(mListener);//注册监听函数
        LocationClientOption option = new LocationClientOption();
        mLocationClient.setLocOption(option);
        mLocationClient.start();
    }

    public class MyLocationListener implements BDLocationListener{

        @Override
        public void onReceiveLocation(BDLocation location){
            double latitude = location.getLatitude();//获取维度
            double longitude = location.getLongitude();//获取精度
            float radius = location.getRadius();//获取定位精度，默认值为0.0f

            Log.i(TAG,"latitude" + latitude);
            Log.i(TAG,"longitude" + longitude);
            Log.i(TAG,"radius" + radius);

            String coorType = location.getCoorType();
            //获取经纬度坐标类型，以LocationClientOption中设置过的坐标类型为准
            int errorCode = location.getLocType();
            //获取定位类型、定位错误返回码，具体信息可参照类参考中的BDLocation类中的说明

        }
    }
}
