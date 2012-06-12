package com.gamespackage.charu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SelectActivity extends Activity implements OnClickListener{

	Button bPlayGame;
	Button bCreateGame;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_activity);
		bPlayGame = (Button)findViewById(R.id.bPlayGame);
		bCreateGame = (Button)findViewById(R.id.bCreateGame);
		bPlayGame.setOnClickListener(this);
		bCreateGame.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==bPlayGame)
		{
			Intent intent = new Intent("com.gamespackage.charu.GAMEMENU");
			startActivity(intent);
			
		}else if(v==bCreateGame)
		{
			Intent intent = new Intent("com.gamespackage.charu.GAMEMENU");
			startActivity(intent);
		}
		
	}
	
	

}
