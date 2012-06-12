package com.gamespackage.charu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class PlayGameSurfaceView extends SurfaceView implements Runnable {

	SurfaceHolder surfaceHolder;
	boolean isRunning = false;
	Thread ourThread = null;
	float x, y;

	public PlayGameSurfaceView(Context context) {
		// TODO Auto-generated constructor stub
		super(context);
		surfaceHolder = getHolder();
		x = 0;
		y = 0;
	}

	public void setSurfaceViewX(float xpos) {
		x = xpos;
	}

	public void setSurfaceViewY(float ypos) {
		y = ypos;
	}

	public void pause() {
		isRunning = false;
		while (true) {
			try {
				ourThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		}
		ourThread = null;
	}

	public void resume() {
		isRunning = true;
		ourThread = new Thread(this);
		ourThread.start();
	}

	public void run() {
		while (isRunning) {
			if (!surfaceHolder.getSurface().isValid()) {
				continue;
			}

			Canvas canvas = surfaceHolder.lockCanvas();
			// draw a background on the canvas
//			 Bitmap backgroundImg =
//			 BitmapFactory.decodeResource(getResources(),
//			 R.drawable.changepicture3);
//			 canvas.drawBitmap(backgroundImg, 0, 0, null);
			canvas.drawRGB( 13, 10, 50);
			if (x != 0 && y != 0) {
				Bitmap movingImg = BitmapFactory.decodeResource(getResources(),
						R.drawable.pinkflower);
				canvas.drawBitmap(movingImg, x - (movingImg.getWidth() / 2), y
						- (movingImg.getHeight() / 2), null);
			}
			surfaceHolder.unlockCanvasAndPost(canvas);
		}
	}

}
