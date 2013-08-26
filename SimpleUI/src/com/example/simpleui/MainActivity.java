package com.example.simpleui;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button sentButton;
	private EditText editText;
	private CheckBox isEncrypt;

	private SharedPreferences sp;
	private SharedPreferences.Editor spEditor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Parse.initialize(this, "9ROnmnwMggPXGo3LkTmGRUVc0N53dHULuwoCyuzN", "v88vezkZot6ENAECKWPjOTUdKml1uswygcrZVH19"); 
		ParseAnalytics.trackAppOpened(getIntent());
		ParseObject testObject = new ParseObject("TestObject");
		testObject.put("foo", "bar");
		testObject.saveInBackground();
		
		sp = getSharedPreferences("setting", Context.MODE_PRIVATE);
		spEditor = sp.edit();

		sentButton = (Button) findViewById(R.id.sentButton);
		editText = (EditText) findViewById(R.id.input);
		isEncrypt = (CheckBox) findViewById(R.id.encrypt);

		String lastText = sp.getString("edit_text", "");
		Boolean isChecked = sp.getBoolean("check_box", false);

		editText.setText(lastText);
		isEncrypt.setChecked(isChecked);

		sentButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.d("debug", "click");
				sendMessage();
			}
		});

		editText.setOnKeyListener(new OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() == KeyEvent.ACTION_DOWN) {
					if (keyCode == KeyEvent.KEYCODE_ENTER) {
						Log.d("debug", "enter");
						sendMessage();
						return true;
					}
				}
				return false;
			}
		});
		editText.setOnKeyListener(new OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub
				String text = editText.getText().toString();
				spEditor.putString("edit_text", text);
				spEditor.commit();
				return false;
			}
		});

		isEncrypt.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				spEditor.putBoolean("check_box", arg1);
				spEditor.commit();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void sendMessage() {
		Editable editable = editText.getText();
		String text = editable.toString();
		if (isEncrypt.isChecked()) {
			text = "************";
		}
		editable.clear();
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

		Intent intent = new Intent();
		intent.setClass(this, messageActivity.class);
		intent.putExtra("text", text);
		startActivity(intent);

	}
}
