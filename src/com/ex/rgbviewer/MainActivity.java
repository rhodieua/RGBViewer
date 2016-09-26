package com.ex.rgbviewer;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView textView1;
	TextView textView2;
	TextView textView3;

	View view;
	
	int red, green, blue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textView1 = (TextView) findViewById(R.id.textView1);
		textView2 = (TextView) findViewById(R.id.textView2);
		textView3 = (TextView) findViewById(R.id.textView3);
		
		textView1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
		textView1.setTextColor(Color.RED);
		textView2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
		textView2.setTextColor(Color.GREEN);
		textView3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
		textView3.setTextColor(Color.BLUE);

		view = (View) findViewById(R.id.view);
		view.setBackgroundColor(Color.BLACK);
		
		SeekBar seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
		seekBar1.setMax(255);
		//seekBar1.setBackgroundColor(Color.RED);
		seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				red = progress;
				
				String hex = Integer.toHexString(progress).toUpperCase();
				hex = (progress < 16) ? "0".concat(hex): hex;
				textView1.setText(hex);
				
				view.setBackgroundColor(Color.rgb(red, green, blue));
			}
		});
		
		SeekBar seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
		seekBar2.setMax(255);
		//seekBar2.setBackgroundColor(Color.GREEN);
		seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				green = progress;
				
				String hex = Integer.toHexString(progress).toUpperCase();
				hex = (progress < 16) ? "0".concat(hex): hex;
				textView2.setText(hex);

				view.setBackgroundColor(Color.rgb(red, green, blue));
			}
		});

		SeekBar seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
		seekBar3.setMax(255);
		//seekBar3.setBackgroundColor(Color.BLUE);
		seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				blue = progress;
				
				String hex = Integer.toHexString(progress).toUpperCase();
				hex = (progress < 16) ? "0".concat(hex): hex;
				textView3.setText(hex);

				view.setBackgroundColor(Color.rgb(red, green, blue));
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
