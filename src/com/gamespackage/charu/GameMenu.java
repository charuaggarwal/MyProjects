package com.gamespackage.charu;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GameMenu extends ListActivity{

	String menuarr[]={"Start Game", "Create Game", "Options Menu", "Shake To Change Picture","Play Game" };
	String menuarrclass[]={"StartGame", "CreateGame", "OptionsMenu", "ChangePictureOnShake", "PlayGame" };
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(GameMenu.this,
				android.R.layout.simple_list_item_1, menuarr));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		try
		{
			Class ourClass = Class.forName("com.gamespackage.charu." + menuarrclass[position]);
			Intent ourIntent = new Intent(GameMenu.this, ourClass);
			startActivity(ourIntent);
		} catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
