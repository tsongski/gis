package com.tsongski.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tsongski.gis.R;

public class DisplayActivity extends Activity {

	private String city;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display);
		Intent intent =getIntent();
		city=intent.getStringExtra("city");
	}

	public void doClick(View view) {
		Intent intent =new Intent(DisplayActivity.this,ListActivity.class);
		switch (view.getId()) {
		case R.id.buttonA:
			intent.putExtra("title", "建筑蓄热能有效百分比");
			intent.putExtra("flag", 1);
			intent.putExtra("city", city);
			break;

		case R.id.buttonB:
			intent.putExtra("title", "夜间有效通风百分比");
			intent.putExtra("flag", 2);
			intent.putExtra("city", city);
			break;
		case R.id.buttonC:
			intent.putExtra("title", "太阳能有效利用百分比");
			intent.putExtra("flag", 3);
			intent.putExtra("city", city);
			break;

		case R.id.buttonD:
			intent.putExtra("title", "自然通风有效百分比");
			intent.putExtra("flag", 4);
			intent.putExtra("city", city);
			break;
		case R.id.buttonE:
			intent.putExtra("title", "直接蒸发有效百分比");
			intent.putExtra("flag", 5);
			intent.putExtra("city", city);
			break;
		case R.id.buttonF:
			intent.putExtra("title", "间接蒸发有效百分比");
			intent.putExtra("flag", 6);
			intent.putExtra("city", city);
			break;

		case R.id.buttonG:
			intent.putExtra("title", "综合措施有效百分比");
			intent.putExtra("flag", 7);
			intent.putExtra("city", city);
			break;
		}
		startActivity(intent);
	}

}
