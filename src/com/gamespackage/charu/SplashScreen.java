package com.gamespackage.charu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		Thread timer = new Thread(){
			public void run()
			{
				try
				{
					sleep(3000);
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}finally{
					Intent intent = new Intent("com.gamespackage.charu.SELECTACTIVITY");
					startActivity(intent);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
