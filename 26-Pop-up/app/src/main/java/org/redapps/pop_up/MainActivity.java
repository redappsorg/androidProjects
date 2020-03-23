package org.redapps.pop_up;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String goldWinner = "Fred Bloggs";
    int goldScore = 98123;
    String silverWinner = "John Doe";
    int silverScore = 54900;
    String bronzeWinner = "Joe Public";
    int bronzeScore = 25789;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //attach an instance of HandleClick to the Button
        findViewById(R.id.button).setOnClickListener(new HandleClick());
    }

    private class HandleClick implements View.OnClickListener {
        public void onClick(View arg0) {
            showWinners();
        }
    }

    private void showWinners() {
        //We need to get the instance of the LayoutInflater, use the context of this activity
        LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Inflate the view from a predefined XML layout (no need for root id, using entire layout)
        View layout = inflater.inflate(R.layout.winners, null);
        //load results
        ((TextView) layout.findViewById(R.id.goldName)).setText(goldWinner);
        ((TextView) layout.findViewById(R.id.goldScore)).setText(String.valueOf(goldScore));
        ((TextView) layout.findViewById(R.id.silverName)).setText(silverWinner);
        ((TextView) layout.findViewById(R.id.silverScore)).setText(String.valueOf(silverScore));
        ((TextView) layout.findViewById(R.id.bronzeName)).setText(bronzeWinner);
        ((TextView) layout.findViewById(R.id.bronzeScore)).setText(String.valueOf(bronzeScore));
        //Get the devices screen density to calculate correct pixel sizes
        float density = MainActivity.this.getResources().getDisplayMetrics().density;
        // create a focusable PopupWindow with the given layout and correct size
        final PopupWindow popupWindow = new PopupWindow(layout, (int) density * 240, (int) density * 285, true);
        //Button to close the pop-up
        ((Button) layout.findViewById(R.id.close)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        //Set up touch closing outside of pop-up
        popupWindow.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    popupWindow.dismiss();
                    return true;
                }
                return false;
            }
        });
        popupWindow.setOutsideTouchable(true);
        // display the pop-up in the center
        popupWindow.showAtLocation(layout, Gravity.CENTER, 0, 0);
    }
}
