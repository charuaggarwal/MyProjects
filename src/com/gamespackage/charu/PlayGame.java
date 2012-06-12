package com.gamespackage.charu;

import android.app.Activity;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class PlayGame extends Activity implements OnTouchListener {

	PlayGameSurfaceView surfaceView;
	float x, y;
	Button hintButton;
	TextView hintText;
	FrameLayout GameArea;
	boolean hintVisibilityFlag = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		GameArea = new FrameLayout(this);
		surfaceView = new PlayGameSurfaceView(this);
		LinearLayout GameWidgets = new LinearLayout(this);

		hintButton = new Button(this);
		hintText = new TextView(this);

		
		LinearLayout.LayoutParams lpButton = new LinearLayout.LayoutParams(30,
				30);
		//lpButton.gravity = Gravity.RIGHT;
		// change the layout, size and background of the hintbutton
		
		hintButton.setLayoutParams(lpButton);
		hintButton.setGravity(Gravity.RIGHT);
		hintButton.setBackgroundResource(R.drawable.hint_button);
		
		// Set text and visibility of the textview
		LinearLayout.LayoutParams lpTextView = new LinearLayout.LayoutParams(
				80, LayoutParams.WRAP_CONTENT);
		lpTextView.gravity = Gravity.RIGHT;
		hintText.setLayoutParams(lpTextView);
		hintText.setText(R.string.hintstr);
		hintText.setVisibility(View.GONE);

		GameWidgets.addView(hintButton);
		GameWidgets.addView(hintText);

		GameArea.addView(surfaceView);
		GameArea.addView(GameWidgets);

		setContentView(GameArea);
		// EndGameButton.setOnClickListener(this);

		// surfaceView = new PlayGameSurfaceView(this);
		surfaceView.setOnTouchListener(this);
		x = 0;
		y = 0;
		// setContentView(surfaceView);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		surfaceView.pause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		surfaceView.resume();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		x = event.getX();
		y = event.getY();
		// see if hint button is clicked. Click is in the area
		// (GameArea.getWidth-hintButton.getwidth to GameArea.getWidth) Or
		// (0 to hintButton.getHeight())

		if ((x > (GameArea.getWidth() - hintButton.getWidth()))
				&& (x <= GameArea.getWidth())
				&& (y > 0 && y <= hintButton.getHeight())) {
			// Simulate press button situation
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				// Hint button clicked
				if (hintVisibilityFlag == true) { // hint was shown so hide it
					hintText.setVisibility(View.GONE);
				} else { // hintHidden so show it
					hintText.setVisibility(View.VISIBLE);
				}
				hintVisibilityFlag = hintVisibilityFlag ? false:true;
				break;
			case MotionEvent.ACTION_UP:

				break;
			case MotionEvent.ACTION_CANCEL:

				break;
			}
			

		} else { // send the event further to surfaceview
			surfaceView.setSurfaceViewX(x);
			surfaceView.setSurfaceViewY(y);
		}
		return true;
	}

}
