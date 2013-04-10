package com.example.TalesOfTheArtic;
import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
//import android.view.View;

public class GameView extends SurfaceView {
      private SurfaceHolder holder;
      private GameLoopThread gameLoopThread;
	  //private long lastClick;
	  private GameView self;
	  private StageSelect stageselect;
	  public Context context;
      
 
      public GameView(Context context) {
            super(context);
            gameLoopThread = new GameLoopThread(this);
            holder = getHolder();
            holder.addCallback(new SurfaceHolder.Callback() {

                   //@Override
                   public void surfaceDestroyed(SurfaceHolder holder) {
                	   boolean retry = true;
                       gameLoopThread.setRunning(false);
                       while (retry) {
                              try {
                                    gameLoopThread.join();
                                    retry = false;
                              } catch (InterruptedException e) {
                              }
                       }
                   }

                   //@Override
                   public void surfaceCreated(SurfaceHolder holder) {
                	   stageselect = new StageSelect(self);
                	   gameLoopThread.setRunning(true);
                       gameLoopThread.start();
                   }

                   //@Override
                   public void surfaceChanged(SurfaceHolder holder, int format,
                                 int width, int height) {
                   }
            });
            this.context = context;
            self = this;            
      }
      
      @Override
      protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.BLACK);
		if(stageselect.active){
			stageselect.draw(canvas);
		}
      }
      
      @Override
      public boolean onTouchEvent(MotionEvent event) {
          //if (System.currentTimeMillis() - lastClick > 500) {
          //lastClick = System.currentTimeMillis();
    	  if(stageselect.active){
    	  	stageselect.onTouch(event);
    	  }
          return true;
      }

}
