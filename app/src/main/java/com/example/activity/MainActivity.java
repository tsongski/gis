package com.example.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMapClickListener;
import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.TextOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.example.keshe.R;
import com.example.tools.AddOverlay;
import com.example.tools.MapUtils;

import java.util.ArrayList;

public class MainActivity extends Activity implements OnMapClickListener,
		OnGetGeoCoderResultListener, OnMarkerClickListener {
	private BaiduMap baiduMap;
	private EditText etCity;
	private EditText etLat, etLng;
	private String cityName;
	private String lat, lng;
	private GeoCoder geo;
	private CheckBox sitellite, overlay, station;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SDKInitializer.initialize(getApplicationContext());
		setContentView(R.layout.activity_main);
		// 创建地理编码对象
		geo = GeoCoder.newInstance();
		// 设置 得到地理编码结果监听
		geo.setOnGetGeoCodeResultListener(this);
		// 设置控件
		setViews();
		MapView mapView = (MapView) findViewById(R.id.bmapView);
		baiduMap = mapView.getMap();
		// 定位到西安
		LatLng cenpt = new LatLng(34.265739, 108.952951);
		// 设置定位层级等
		MapStatus mMapStatus = new MapStatus.Builder().target(cenpt).zoom(5)
				.build();
		baiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(mMapStatus));
		baiduMap.setOnMarkerClickListener(this);
		// 添加文字 和 多边形覆盖物
		baiduMap.setOnMapClickListener(new OnMapClickListener() {
			
			@Override
			public boolean onMapPoiClick(MapPoi arg0) {
				return false;
			}
			
			@Override
			public void onMapClick(LatLng latLng) {
				Log.i("latLng", "" + latLng.latitude + " " + latLng.longitude);
				baiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
				TextView tv = new TextView(MainActivity.this);
				tv.setBackgroundResource(R.drawable.popup);
				tv.setTextColor(0xff000000);
				tv.setText("经度:" + latLng.latitude + "纬度:" + latLng.longitude);
				RouteNode routeNode = new RouteNode();
				routeNode.setLocation(latLng);
				InfoWindow infoWindow = new InfoWindow(tv, routeNode.getLocation(), 0);
				baiduMap.showInfoWindow(infoWindow);
			}
		});

	}

	private void setViews() {
		etCity = (EditText) findViewById(R.id.city);
		etLat = (EditText) findViewById(R.id.etLat);
		etLng = (EditText) findViewById(R.id.etLng);
		sitellite = (CheckBox) findViewById(R.id.sitellite);
		sitellite.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// 如果选中 地图设置为 卫星模式
				if (isChecked) {
					baiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
				}
				// 如果未被选中 地图设置为 正常模式
				else {
					baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
				}

			}
		});
		overlay = (CheckBox) findViewById(R.id.overlay);
		overlay.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {

				// 如果选中 地图添加气象覆盖物
				if (isChecked) {
					drawPolygonOverlays();
					drawTextOverlays();
				}
				// 如果未被选中 则不添加气象覆盖物
				else {
					baiduMap.clear();
				}
			}
		});
		station = (CheckBox) findViewById(R.id.station);
		station.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				//如果选中   添加气象站
				if(isChecked){
					LatLng lat_beijing=new LatLng(39.839372,117.1077);
					MarkerOptions marker = new MarkerOptions().position(
							lat_beijing).icon(
							BitmapDescriptorFactory.fromResource(R.drawable.icon_gcoding));
					baiduMap.addOverlay(marker);
					LatLng lat_xinjiang=new LatLng(44.734893,86.874724);
					MarkerOptions marker2 = new MarkerOptions().position(
							lat_xinjiang).icon(
							BitmapDescriptorFactory.fromResource(R.drawable.icon_gcoding));
					baiduMap.addOverlay(marker2);
					// 地图中心聚焦到marker坐标处
					//baiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(result
					//		.getLocation()));
				}
				//如果未被选中   移除气象站
				else{
					baiduMap.clear();
					drawPolygonOverlays();
					drawTextOverlays();
				}
			}
		});
	}

	private void drawTextOverlays() {
		TextOptions text = new TextOptions();
		text.text("严寒地区");
		text.position(new LatLng(34.37795, 85.544944));
		text.fontSize(30);
		baiduMap.addOverlay(text);
		TextOptions text2 = new TextOptions();
		text2.text("夏热冬冷地区");
		text2.position(new LatLng(29.547314, 111.385436));
		text2.fontSize(30);
		baiduMap.addOverlay(text2);
		TextOptions text3 = new TextOptions();
		text3.text("温和地区");
		text3.position(new LatLng(24.732645, 102.118265));
		text3.fontSize(30);
		baiduMap.addOverlay(text3);
		TextOptions text4 = new TextOptions();
		text4.text("寒冷地区");
		text4.position(new LatLng(29.437015, 88.028579));
		text4.fontSize(30);
		baiduMap.addOverlay(text4);
		TextOptions text5 = new TextOptions();
		text5.text("寒冷地区");
		text5.position(new LatLng(38.926507, 80.46729));
		text5.fontSize(30);
		baiduMap.addOverlay(text5);
		TextOptions text6 = new TextOptions();
		text6.text("严寒地区");
		text6.position(new LatLng(44.641791, 83.484447));
		text6.fontSize(30);
		baiduMap.addOverlay(text6);
		TextOptions text7 = new TextOptions();
		text7.text("严寒地区");
		text7.position(new LatLng(40.080924, 98.091901));
		text7.fontSize(30);
		baiduMap.addOverlay(text7);
		TextOptions text8 = new TextOptions();
		text8.text("严寒地区");
		text8.position(new LatLng(43.894879, 116.305225));
		text8.fontSize(30);
		baiduMap.addOverlay(text8);
		TextOptions text9 = new TextOptions();
		text9.text("寒冷地区");
		text9.position(new LatLng(35.438853, 104.935695));
		text9.fontSize(30);
		baiduMap.addOverlay(text9);
		TextOptions text10 = new TextOptions();
		text10.text("夏热冬暖地区");
		text10.position(new LatLng(23.411454, 108.412784));
		text10.fontSize(30);
		baiduMap.addOverlay(text10);
	}

	private void drawPolygonOverlays() {
		ArrayList<LatLng> list_Neimeng = AddOverlay.add_Neimeng();
		MapUtils.drawBorder(baiduMap, list_Neimeng, 0xaaED94FF);
		ArrayList<LatLng> list_Jixin = AddOverlay.add_Jixin();
		MapUtils.drawBorder(baiduMap, list_Jixin, 0xaa6A9ACB);
		ArrayList<LatLng> list_Wulumuqi = AddOverlay.add_Wulumuqi();
		MapUtils.drawBorder(baiduMap, list_Wulumuqi, 0xaaED94FF);
		ArrayList<LatLng> list_Xinjiang = AddOverlay.add_Xinjiang();
		MapUtils.drawBorder(baiduMap, list_Xinjiang, 0xaa84ABD6);
		ArrayList<LatLng> list_Xizang = AddOverlay.add_Xizang();
		MapUtils.drawBorder(baiduMap, list_Xizang, 0xaaeda4fe);
		ArrayList<LatLng> list_Hainan = AddOverlay.add_Hainan();
		MapUtils.drawBorder(baiduMap, list_Hainan, 0xaaF3767E);
		ArrayList<LatLng> list_Taiwan = AddOverlay.add_Taiwan();
		MapUtils.drawBorder(baiduMap, list_Taiwan, 0xaaF3767E);
		ArrayList<LatLng> list_Guangzhou = AddOverlay.add_Guangzhou();
		MapUtils.drawBorder(baiduMap, list_Guangzhou, 0xaaF3767E);
		ArrayList<LatLng> list_Chongqing = AddOverlay.add_Chongqing();
		MapUtils.drawBorder(baiduMap, list_Chongqing, 0xaaFEFA8F);
		ArrayList<LatLng> list_Kunming = AddOverlay.add_Kunming();
		MapUtils.drawBorder(baiduMap, list_Kunming, 0xaa87D392);
		ArrayList<LatLng> list_Lasa = AddOverlay.add_Lasa();
		MapUtils.drawBorder(baiduMap, list_Lasa, 0xaa6A99CA);
	}

	@Override
	public void onMapClick(LatLng latLng) {
		Log.i("latLng", "" + latLng.latitude + " " + latLng.longitude);
		baiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
		TextView tv = new TextView(MainActivity.this);
		tv.setBackgroundResource(R.drawable.popup);
		tv.setTextColor(0xff000000);
		tv.setText("经度:" + latLng.latitude + "纬度:" + latLng.longitude);
		RouteNode routeNode = new RouteNode();
		routeNode.setLocation(latLng);
		InfoWindow infoWindow = new InfoWindow(tv, routeNode.getLocation(), 0);
		baiduMap.showInfoWindow(infoWindow);
	}

	@Override
	public boolean onMapPoiClick(MapPoi arg0) {
		return false;
	}

	public void doClick(View view) {

		switch (view.getId()) {
		case R.id.queryByCity:
			// 获取城市输入框内容
			cityName = etCity.getText().toString();
			// 创建 地理编码参数对象
			GeoCodeOption option = new GeoCodeOption();
			// 给地理编码参数对象添城市 地点参数
			option.city(cityName);
			option.address(cityName);
			// 进行地理编码查询
			geo.geocode(option);
			break;

		case R.id.queryByLocation:

			lat = etLat.getText().toString();
			lng = etLng.getText().toString();
			Log.i("location", "lat:" + lat + "lng" + lng);
			break;
		}

	}

	@Override
	public void onGetGeoCodeResult(GeoCodeResult result) {
		if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
			Toast.makeText(MainActivity.this, "对不起，找不到结果呐", Toast.LENGTH_LONG)
					.show();
			return;
		}
		// 清除地图上原有的marker 以及 overlay
		baiduMap.clear();
		// 添加多边形和文字覆盖物
		drawTextOverlays();
		drawPolygonOverlays();
		MarkerOptions marker = new MarkerOptions().position(
				result.getLocation()).icon(
				BitmapDescriptorFactory.fromResource(R.drawable.icon_gcoding));
		baiduMap.addOverlay(marker);
		// 地图中心聚焦到marker坐标处
		baiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(result
				.getLocation()));
	}

	@Override
	public void onGetReverseGeoCodeResult(ReverseGeoCodeResult arg0) {

	}

	@Override
	public boolean onMarkerClick(Marker marker) {
		Log.i("marker", marker.getPosition().toString());
		// 跳转到详细信息
		Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
		intent.putExtra("city", etCity.getText().toString());
		startActivity(intent);
		return false;
	}

}
