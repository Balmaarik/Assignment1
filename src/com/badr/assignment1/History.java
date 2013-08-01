package com.badr.assignment1;

import com.badr.assignment1.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class History extends Activity {
	/**
	 * Whether or not the system UI should be auto-hidden after
	 * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
	 */
	
	TextView textView1, textView2, textView3, textView4, textView5;
	 ListView listView ;
	
	private static final boolean AUTO_HIDE = true;

	/**
	 * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
	 * user interaction before hiding the system UI.
	 */
	private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

	/**
	 * If set, will toggle the system UI visibility upon interaction. Otherwise,
	 * will show the system UI visibility upon interaction.
	 */
	private static final boolean TOGGLE_ON_CLICK = true;

	/**
	 * The flags to pass to {@link SystemUiHider#getInstance}.
	 */
	private static final int HIDER_FLAGS = SystemUiHider.FLAG_HIDE_NAVIGATION;

	/**
	 * The instance of the {@link SystemUiHider} for this activity.
	 */
	private SystemUiHider mSystemUiHider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_history);

		//View controlsView = findViewById(R.id.fullscreen_content_controls);
		//final View contentView = findViewById(R.id.fullscreen_content);
		
		listView = (ListView) findViewById(R.id.list);
		
	
		SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, 0);
	    String result1 = settings.getString("result1", "no value!");
	    String result2 = settings.getString("result2", "no value!");
	    String result3 = settings.getString("result3", "no value!");
	    String result4 = settings.getString("result4", "no value!");
	    String result5 = settings.getString("result5", "no value!");
	    
	    
	    String[] list = {
	    	result1,
	    	result2,
	    	result3,
	    	result4,
	    	result5
	    };
	    
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	              android.R.layout.simple_list_item_1, android.R.id.text1, list);
	    
	    listView.setAdapter(adapter); 
	   
	    listView.setOnItemClickListener(new OnItemClickListener() {
	    	 
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
               int position, long id) {
              
             // ListView Clicked item index
             int itemPosition     = position;
             
             // ListView Clicked item value
             String  itemValue    = (String) listView.getItemAtPosition(position);
             
             
             Intent returnIntent = new Intent();
             returnIntent.putExtra("result", itemValue);
             setResult(RESULT_OK,returnIntent);     
             finish();
           
            }

       }); 
  }


	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		setResult(RESULT_CANCELED);
		super.onBackPressed();
	}

}

