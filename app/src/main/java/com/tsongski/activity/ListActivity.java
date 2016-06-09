package com.tsongski.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tsongski.entity.Entity;
import com.tsongski.gis.R;
import com.tsongski.tools.DBContext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ListActivity extends Activity {

	private ArrayList<Entity> dataList;
	private DBContext db;
	private String city;
	private TextView tvtitle;
	private int flag;
	private TextView tvCity, tvJan, tvFeb, tvMar, tvApr, tvMay, tvJune, tvJuly,
			tvAug, tvSep, tvOct, tvNov, tvDec, tvAvg;
	private String title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		setViews();
		db = new DBContext(this);
		Intent intent = getIntent();
		city = intent.getStringExtra("city");
		title = intent.getStringExtra("title");
		flag = intent.getIntExtra("flag", 0);
		tvtitle.setText(title);
		Cursor c = null;
		switch (flag) {
		case 0:
			Toast.makeText(this, "数据不存在!", Toast.LENGTH_SHORT).show();
			break;
		case 1:
			c = db.query_a(city);
			while (c.moveToNext()) {
				tvCity.setText(c.getString(1));
				tvJan.setText(c.getString(2));
				tvFeb.setText(c.getString(3));
				tvMar.setText(c.getString(4));
				tvApr.setText(c.getString(5));
				tvMay.setText(c.getString(6));
				tvJune.setText(c.getString(7));
				tvJuly.setText(c.getString(8));
				tvAug.setText(c.getString(9));
				tvSep.setText(c.getString(10));
				tvOct.setText(c.getString(11));
				tvNov.setText(c.getString(12));
				tvDec.setText(c.getString(13));
				tvAvg.setText(c.getString(14));
			}
			break;
		case 2:
			c = db.query_b(city);
			while (c.moveToNext()) {
				tvCity.setText(c.getString(1));
				tvJan.setText(c.getString(2));
				tvFeb.setText(c.getString(3));
				tvMar.setText(c.getString(4));
				tvApr.setText(c.getString(5));
				tvMay.setText(c.getString(6));
				tvJune.setText(c.getString(7));
				tvJuly.setText(c.getString(8));
				tvAug.setText(c.getString(9));
				tvSep.setText(c.getString(10));
				tvOct.setText(c.getString(11));
				tvNov.setText(c.getString(12));
				tvDec.setText(c.getString(13));
				tvAvg.setText(c.getString(14));
			}
			break;
		case 3:
			c = db.query_c(city);
			while (c.moveToNext()) {
				tvCity.setText(c.getString(1));
				tvJan.setText(c.getString(2));
				tvFeb.setText(c.getString(3));
				tvMar.setText(c.getString(4));
				tvApr.setText(c.getString(5));
				tvMay.setText(c.getString(6));
				tvJune.setText(c.getString(7));
				tvJuly.setText(c.getString(8));
				tvAug.setText(c.getString(9));
				tvSep.setText(c.getString(10));
				tvOct.setText(c.getString(11));
				tvNov.setText(c.getString(12));
				tvDec.setText(c.getString(13));
				tvAvg.setText(c.getString(14));
			}
			break;
		case 4:
			c = db.query_d(city);
			while (c.moveToNext()) {
				tvCity.setText(c.getString(1));
				tvJan.setText(c.getString(2));
				tvFeb.setText(c.getString(3));
				tvMar.setText(c.getString(4));
				tvApr.setText(c.getString(5));
				tvMay.setText(c.getString(6));
				tvJune.setText(c.getString(7));
				tvJuly.setText(c.getString(8));
				tvAug.setText(c.getString(9));
				tvSep.setText(c.getString(10));
				tvOct.setText(c.getString(11));
				tvNov.setText(c.getString(12));
				tvDec.setText(c.getString(13));
				tvAvg.setText(c.getString(14));
			}
			break;
		case 5:
			c = db.query_e(city);
			while (c.moveToNext()) {
				tvCity.setText(c.getString(1));
				tvJan.setText(c.getString(2));
				tvFeb.setText(c.getString(3));
				tvMar.setText(c.getString(4));
				tvApr.setText(c.getString(5));
				tvMay.setText(c.getString(6));
				tvJune.setText(c.getString(7));
				tvJuly.setText(c.getString(8));
				tvAug.setText(c.getString(9));
				tvSep.setText(c.getString(10));
				tvOct.setText(c.getString(11));
				tvNov.setText(c.getString(12));
				tvDec.setText(c.getString(13));
				tvAvg.setText(c.getString(14));
			}
			break;
		case 6:
			c = db.query_f(city);
			while (c.moveToNext()) {
				tvCity.setText(c.getString(1));
				tvJan.setText(c.getString(2));
				tvFeb.setText(c.getString(3));
				tvMar.setText(c.getString(4));
				tvApr.setText(c.getString(5));
				tvMay.setText(c.getString(6));
				tvJune.setText(c.getString(7));
				tvJuly.setText(c.getString(8));
				tvAug.setText(c.getString(9));
				tvSep.setText(c.getString(10));
				tvOct.setText(c.getString(11));
				tvNov.setText(c.getString(12));
				tvDec.setText(c.getString(13));
				tvAvg.setText(c.getString(14));
			}
			break;
		case 7:
			c = db.query_g(city);
			while (c.moveToNext()) {
				tvCity.setText(c.getString(1));
				tvJan.setText(c.getString(2));
				tvFeb.setText(c.getString(3));
				tvMar.setText(c.getString(4));
				tvApr.setText(c.getString(5));
				tvMay.setText(c.getString(6));
				tvJune.setText(c.getString(7));
				tvJuly.setText(c.getString(8));
				tvAug.setText(c.getString(9));
				tvSep.setText(c.getString(10));
				tvOct.setText(c.getString(11));
				tvNov.setText(c.getString(12));
				tvDec.setText(c.getString(13));
				tvAvg.setText(c.getString(14));
			}
			break;

		}
	}

	private void setViews() {
		tvtitle = (TextView) findViewById(R.id.title);
		tvCity = (TextView) findViewById(R.id.tvCity);
		tvJan = (TextView) findViewById(R.id.tvJan);
		tvFeb = (TextView) findViewById(R.id.tvFeb);
		tvMar = (TextView) findViewById(R.id.tvMar);
		tvApr = (TextView) findViewById(R.id.tvApr);
		tvMay = (TextView) findViewById(R.id.tvMay);
		tvJune = (TextView) findViewById(R.id.tvJune);
		tvJuly = (TextView) findViewById(R.id.tvJuly);
		tvAug = (TextView) findViewById(R.id.tvAug);
		tvSep = (TextView) findViewById(R.id.tvSep);
		tvOct = (TextView) findViewById(R.id.tvOct);
		tvNov = (TextView) findViewById(R.id.tvNov);
		tvDec = (TextView) findViewById(R.id.tvDec);
		tvAvg = (TextView) findViewById(R.id.tvAvg);
	}

	public void doClick(View view) {
		setdata();
		for (int i = 0; i < dataList.size(); i++) {
			Entity entity = dataList.get(i);
			db.insert_a(entity);
		}
		Cursor c = db.query_a(city);
		String feb = "";
		while (c.moveToNext()) {
			feb = c.getString(2);
		}
		Log.i("tag", "" + db.query_a().getCount());
		Log.i("tag", "" + c.getCount());
		Log.i("feb", "" + feb);
	}

	private void setdata() {
		dataList = new ArrayList<Entity>();
		String path = "";
		try {
			if (Environment.MEDIA_MOUNTED.equals(Environment
					.getExternalStorageState())) {
				path = Environment.getExternalStorageDirectory()
						.getAbsolutePath();
			} else {
				Toast.makeText(this, "内存卡不存在", Toast.LENGTH_SHORT).show();
				path = getFilesDir().getAbsolutePath();
				Log.i("tag", path);
			}

			File file = new File(path, "a.txt");
			FileInputStream in = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] arr = line.split("[\\s]+");
				Entity entity = new Entity();
				entity.setCity(arr[0]);
				entity.setM1(arr[1]);
				entity.setM2(arr[2]);
				entity.setM3(arr[3]);
				entity.setM4(arr[4]);
				entity.setM5(arr[5]);
				entity.setM6(arr[6]);
				entity.setM7(arr[7]);
				entity.setM8(arr[8]);
				entity.setM9(arr[9]);
				entity.setM10(arr[10]);
				entity.setM11(arr[11]);
				entity.setM12(arr[12]);
				entity.setYear(arr[13]);
				dataList.add(entity);
				Log.i("city", entity.getCity());
			}
			br.close();
			Log.i("length", dataList.size() + "");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
