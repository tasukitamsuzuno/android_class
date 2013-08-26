package com.example.sampleuicontrol;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView Text;
	private Button leftButton;
	private Button rightButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Text=(TextView) findViewById(R.id.textView1);
		leftButton =(Button) findViewById(R.id.button1);
		leftButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				RelativeLayout.LayoutParams Layout=(LayoutParams) Text.getLayoutParams();
				Layout.leftMargin --;
				Text.setLayoutParams(Layout);
			}
		});
		
		rightButton =(Button) findViewById(R.id.button2);
		rightButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				RelativeLayout.LayoutParams Layout=(LayoutParams) Text.getLayoutParams();
				Layout.leftMargin ++;
				Text.setLayoutParams(Layout);
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
