package com.example.keyboardvaluelog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends Activity {

	EditText t1;
	
	File dir,file;
	String filePath;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		t1	= (EditText)findViewById(R.id.myedit_text);
		
		filePath 		= Environment.getExternalStorageDirectory().getAbsolutePath() + "/keyLogData";
		dir				= new File(filePath);
		
		if(!dir.exists()){
        	dir.mkdirs();
        }
        file				= new File(dir, "keyboard_log.txt");
        
        t1.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
				//Log.e("test",""+s.charAt(s.length()-1));
				
				//Log.e("test",""+s.length());
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				/*Log.e("test",""+s.charAt(s.length()-1));
				
				Log.e("test",""+s.length());*/
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				char c = s.charAt(s.length()-1);
				Log.e("test",""+(int)c);
				try
				   {
					   
				   String key	= "Pressed Key Code:"+(int)c+" Current Time:"+System.currentTimeMillis();
				   
			       FileOutputStream fOut = new FileOutputStream(file,true);
			       OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
			       myOutWriter.write("\n"+key);
			       myOutWriter.close();
			       fOut.close();
			    } catch(Exception e)
			    {

			    }
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
