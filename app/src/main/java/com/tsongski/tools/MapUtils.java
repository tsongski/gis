package com.tsongski.tools;

import java.util.ArrayList;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.PolygonOptions;
import com.baidu.mapapi.model.LatLng;

public class MapUtils {

	private static PolygonOptions points;

	public static void drawBorder(BaiduMap baiduMap,ArrayList<LatLng> list,int color){
		points = new PolygonOptions().points(list);
		points.fillColor(color);
		baiduMap.addOverlay(points);
	}
}
