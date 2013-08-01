package com.badr.assignment1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	public static final String PREFS_NAME = "MyPrefsFile";

	Double total, var1 = 0.0 , var2 = 0.0 ;
	int counter = 1;
	Button n1, n2, n3, n4, n5, n6, n7, n8, n9, n0, op_plus, op_minus, op_times, dot, equals_button, ac, history;
	TextView result;
	String s, first_num, second_num, operator;
	Boolean operator_clicked;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		n1 = (Button) findViewById(R.id.number1);
		n2 = (Button) findViewById(R.id.number2);
		n3 = (Button) findViewById(R.id.number3);
		n4 = (Button) findViewById(R.id.number4);
		n5 = (Button) findViewById(R.id.number5);
		n6 = (Button) findViewById(R.id.number6);
		n7 = (Button) findViewById(R.id.number7);
		n8 = (Button) findViewById(R.id.number8);
		n9 = (Button) findViewById(R.id.number9);
		n0 = (Button) findViewById(R.id.number0);
		
		history = (Button) findViewById(R.id.history1);
		
		ac = (Button) findViewById(R.id.ac);
		
		op_plus = (Button) findViewById(R.id.plus_button);
		op_minus = (Button) findViewById(R.id.minus_button);
		op_times = (Button) findViewById(R.id.mult_button);
		dot = (Button) findViewById(R.id.dot_button);
		equals_button = (Button) findViewById(R.id.equals_button);
		result = (TextView) findViewById(R.id.result);
		
		MyNumbersListener number_button = new MyNumbersListener();
		
		n1.setOnClickListener(number_button);
		n2.setOnClickListener(number_button);
		n3.setOnClickListener(number_button);
		n4.setOnClickListener(number_button);
		n5.setOnClickListener(number_button);
		n6.setOnClickListener(number_button);
		n7.setOnClickListener(number_button);
		n8.setOnClickListener(number_button);
		n9.setOnClickListener(number_button);
		n0.setOnClickListener(number_button);
		dot.setOnClickListener(number_button);
		
		MyOperatorsListener operator_button = new MyOperatorsListener();
		
		op_plus.setOnClickListener(operator_button);
		op_minus.setOnClickListener(operator_button);
		op_times.setOnClickListener(operator_button);
		op_plus.setOnClickListener(operator_button);
		
		ac.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				var1 = 0.0;
				result.setText("");
			}
		});
		
		
		
		history.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, History.class);
				startActivityForResult(intent, 1);
				
			}
		});
		
		
		
		equals_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				var2 = Double.parseDouble(result.getText().toString());
				if ("+".equals(operator) ){
					total = var1 + var2;
				}else if ("-".equals(operator)){
					total = var1 - var2;
				}else if ("*".equals(operator)){
					total = var1 * var2;
				}
				//result.setText(total.toString());
				result.setText(String.format("%.4f", total));
				var1 = total;
				
				SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
			    SharedPreferences.Editor editor = settings.edit();
			    
			    switch (counter){
			    case 1:
			    	editor.putString("result1", result.getText().toString());
			    	counter++;
			    	break;
			    case 2:
			    	editor.putString("result2", result.getText().toString());
			    	counter++;
			    	break;
			    case 3:
				    editor.putString("result3", result.getText().toString());
				    counter++;
				    break;
			    case 4:
			    	editor.putString("result4", result.getText().toString());
			    	counter++;
			    	break;
			    case 5:
			    	editor.putString("result5", result.getText().toString());
			    	counter = 1;
			    	break;
			    	
			    }
			    
			    editor.commit();
		}
	});
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 1 && resultCode == Activity.RESULT_OK)
		{
			String result101=data.getStringExtra("result");
			result.setText(result101);
		}
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	class MyNumbersListener implements OnClickListener
	{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Button clicked = (Button) v;
			//int number = Integer.parseInt(clicked.getText().toString());
			String name = (String)clicked.getText().toString();
			//switch(number) {
			//	case 1:	
			result.append(name);			
		}
			
	}
	
	class MyOperatorsListener implements OnClickListener
	{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Button clicked = (Button) v;
			String name = (String)clicked.getText().toString();
		
			if("+".equals(name)){
				operator = "+";
			}else if("-".equals(name) ){
				operator = "-"; 
			}else if("x".equals(name)){
				operator = "*"; 
			}
			operator_clicked = true;
			var1 = Double.parseDouble(result.getText().toString());
			result.setText("");	
		}
	}
}