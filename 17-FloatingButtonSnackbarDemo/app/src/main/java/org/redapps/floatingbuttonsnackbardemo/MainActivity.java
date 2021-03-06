package org.redapps.floatingbuttonsnackbardemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, pickRandomMessage(), Snackbar.LENGTH_LONG)
                        .setAction("Tap Me!", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.d(TAG, "We should do something here");
                                startActivity(new Intent(MainActivity.this, NextActivity.class));
                            }
                        }).show();
            }
        });
    }

    String pickRandomMessage() {
        return "Vote early and often!";
    }
}
