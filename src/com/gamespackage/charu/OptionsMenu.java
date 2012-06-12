package com.gamespackage.charu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class OptionsMenu extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_options_menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		// return super.onCreateOptionsMenu(menu);
		MenuInflater menuInflater= getMenuInflater();
		menuInflater.inflate(R.layout.options_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		//
		switch(item.getItemId())
		{
		case R.id.continue_game:
			Toast.makeText(OptionsMenu.this, "You Clicked Continue Game", 3000).show();
            return true;
		case R.id.new_game:
			Toast.makeText(OptionsMenu.this, "You Clicked New Game", 3000).show();
            return true;
		case R.id.about_game:
			Toast.makeText(OptionsMenu.this, "You Clicked About Game", 3000).show();
            return true;
		case R.id.help_game:
			Toast.makeText(OptionsMenu.this, "You Clicked Help Game", 3000).show();
            return true;
            default:
            	return super.onOptionsItemSelected(item);
            	
		
		}
	}
	
	

		
}
