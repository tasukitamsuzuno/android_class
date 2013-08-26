package com.example.simpleui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


	public class messageActivity extends Activity{
		
		private ListView listView;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.message);
			
			listView =(ListView) findViewById(R.id.listView1);
			String text =getIntent().getStringExtra("text");
			
			WriteFile(text);
			String[] data=readFile().split("\n");
			ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1,data);
			listView.setAdapter(adapter);
	}
		private void WriteFile(String text){
			
			try {
				
				FileOutputStream fos = openFileOutput("message_history",
						Context.MODE_APPEND);
				text+="\n";
				fos.write(text.getBytes());
				fos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private String readFile(){
			String text="";
			try {
				FileInputStream fis =openFileInput("message_history");
				byte [] buffer =new byte[1024];
				fis.read(buffer);
				text=new String(buffer);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
			return text;
		}
		
}
