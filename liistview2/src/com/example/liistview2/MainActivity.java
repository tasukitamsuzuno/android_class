package com.example.liistview2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	private ListView listview;
	private final static String[] URLS = {
			"http://www.google.com/doodles/moon-festival-mid-autumn-festival-2012",
			"http://www.google.com/doodles/anton-bernolaks-250th-birthday",
			"http://www.google.com/doodles/niels-bohrs-127th-birthday",
			"http://www.google.com/doodles/brazilian-elections-2012",
			"http://www.google.com/doodles/chuseok-2012",
			"http://www.google.com/doodles/david-unaipons-140th-birthday",
			"http://www.google.com/doodles/francisco-gabilondo-solers-105th-birthday",
			"http://www.google.com/doodles/brian-o-nuallains-101st-birthday",
			"http://www.google.com/doodles/german-reunification-day-2012",
			"http://www.google.com/doodles/janusz-korczaks-year" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listview = (ListView) findViewById(R.id.listView1);

		int[] imgStr = { R.drawable.g0, R.drawable.g1, R.drawable.g2,
				R.drawable.g3, R.drawable.g4, R.drawable.g5, R.drawable.g6,
				R.drawable.g7, R.drawable.g8, R.drawable.g9 };

		String[] text = { "image0", "image1", "image2", "image3", "image4",
				"image5", "image6", "image7", "image8", "image9" };

		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < imgStr.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", imgStr[i]);
			map.put("text", text[i]);
			data.add(map);
		}
		String[] from = { "image", "text" };
		int[] to = { R.id.imageView1, R.id.textView1 };
		SimpleAdapter adapter = new SimpleAdapter(this, data,
				R.layout.listview_item, from, to);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse(URLS[position]);
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(intent);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
