package com.gamespackage.charu;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class ChangePictureOnShake extends Activity implements SensorEventListener{

	private SensorManager sensorManager;
	String imageResourceName[]={"changepicture1", "changepicture2", "changepicture3"};
	private int counter=1;
	private ImageView img_view;
	private long lastUpdate;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.change_picture);
		 img_view=(ImageView)findViewById(R.id.changepicture);
		img_view.setImageResource(R.drawable.changepicture1);
		
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 
        								sensorManager.SENSOR_DELAY_NORMAL);
        lastUpdate = System.currentTimeMillis();
		
	}

	@Override
	public void onSensorChanged(SensorEvent e) {
		// TODO Auto-generated method stub
		if(e.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
    	{
    		getAccelerometer(e);
    	}
	}
	private void getAccelerometer(SensorEvent e)
    {
    		float values[] = e.values;
    		
    		float x = values[0];
    		float y = values[1];
    		float z = values[2];
    		
    		float accelationSquareRoot = (x * x + y * y + z * z)
    				/ (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
    		
    		long actualTime = System.currentTimeMillis();
    		if (accelationSquareRoot >= 2) //
    		{
    			if (actualTime - lastUpdate < 200) {
    				return;
    			}
    			lastUpdate = actualTime;
    			Toast.makeText(this, "Device was shuffled", Toast.LENGTH_SHORT)
    					.show();
    			switch(counter)
    			{
    			case 0:
    				img_view.setImageResource(R.drawable.changepicture1);
    				break;
    			case 1:
    				img_view.setImageResource(R.drawable.changepicture2);
    				break;
    			case 2:
    				img_view.setImageResource(R.drawable.changepicture3);
    				break;	
    			}
    			counter = (counter+1)%3;
    		}
    }
	
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		sensorManager.unregisterListener(this);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
    	sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 
    									SensorManager.SENSOR_DELAY_NORMAL);
	}

}
