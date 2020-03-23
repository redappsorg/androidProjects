package org.redapps.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_COUNTER = "counter";
    TextView number;
    Button next;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = (TextView) findViewById(R.id.number);
        counter = 0;
        number.setText(String.valueOf(counter));
        if(savedInstanceState != null){
            counter = savedInstanceState.getInt(KEY_COUNTER, 0);
            number.setText(String.valueOf(counter));
        }

        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = Integer.parseInt(number.getText().toString()) + 1;
                number.setText(String.valueOf(counter));
            }
        });
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNTER, counter);
    }
}
