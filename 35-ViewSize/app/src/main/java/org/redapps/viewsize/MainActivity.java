package org.redapps.viewsize;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //object to store display information
        DisplayMetrics metrics = new DisplayMetrics();
        //get display information
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        //show display width and height
        ((TextView) findViewById(R.id.textXY)).setText(
                Integer.toString(metrics.widthPixels) + "," + Integer.toString(metrics.heightPixels));

        //Reference ImageView
        ImageView v = (ImageView) findViewById(R.id.imageView);
        //Attached a layout listener
        v.getViewTreeObserver().addOnGlobalLayoutListener(new MyGlobalListenerClass());
    }

    //Declare the layout listener
    private class MyGlobalListenerClass implements ViewTreeObserver.OnGlobalLayoutListener {
        @Override
        public void onGlobalLayout() {
            View v = (View) findViewById(R.id.imageView);
            String x = Integer.toString(v.getWidth());
            String y = Integer.toString(v.getHeight());
            //show ImageView width and height
            ((TextView) findViewById(R.id.imageXY)).setText(x + "," + y);
        }
    }

    //Size after laying out finished
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        View v = (View) findViewById(R.id.screen);
        String x = Integer.toString(v.getWidth());
        String y = Integer.toString(v.getHeight());
        //show ImageView width and height
        ((TextView) findViewById(R.id.layoutXY)).setText(x + "," + y);
    }
}
