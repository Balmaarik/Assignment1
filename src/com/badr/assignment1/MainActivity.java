package com.badr.assignment1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	Double total, var1, var2 ;
	Button equals, exit;
	EditText t1, t2, t3;
	TextView result;
	String s;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		equals = (Button) findViewById(R.id.button1);
		exit = (Button) findViewById(R.id.button2);
		result = (TextView) findViewById(R.id.textView1);
		equals.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				t1 = (EditText) findViewById(R.id.editText1);
				t2 = (EditText) findViewById(R.id.editText2);
				t3 = (EditText) findViewById(R.id.editText3);
				
				 var1 = Double.parseDouble(t1.getText().toString());
				 var2 = Double.parseDouble(t3.getText().toString());
				 s = t2.getText().toString();
				 
				 if ("+".equals(s) ) {
						total = var1 +  var2;
				}else if ("-".equals(s) ) {
					total = var1 -  var2;
				}else if ("*".equals(s) ) {
					total = var1 *  var2;
				}else if ("/".equals(s) ) {
					total = var1 / var2;
				}else if ("add".equals(s) ) {
					total = var1 + var2;
				}else {
					total =  0.0;
				}
					
				//result.setText(new Float(total).toString());
				result.setText(String.format("%.4f", total));
			}
		});
		exit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
				System.exit(0);
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
