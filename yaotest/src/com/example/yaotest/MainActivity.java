package com.example.yaotest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText editText;
	private Button button;
	private CheckBox isEncrypt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editText1);
        button=(Button)findViewById(R.id.button1);
        isEncrypt=(CheckBox) findViewById(R.id.checkBox1);
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				sendMessage();
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private void  sendMessage() {
    	String content =editText.getText().toString();
    	if(isEncrypt.isChecked()==true){
    		content="*********";
    	}
    	Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    	editText.getText().clear();
	}
    
}
