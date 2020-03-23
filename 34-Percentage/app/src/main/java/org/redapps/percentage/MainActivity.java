package org.redapps.percentage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText percentage = (EditText) findViewById(R.id.editText);
        percentage.addTextChangedListener(new CheckPercentage());
    }

    private class CheckPercentage implements TextWatcher {
        public void afterTextChanged(Editable editable) {
            try {
                Log.d("Percentage", "input: " + editable);
                if (Integer.parseInt(editable.toString()) > 100)
                    editable.replace(0, editable.length(), "100");
            } catch (NumberFormatException ignored) {
            }
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // Not used, details on text just before it changed
            // used to track in detail changes made to text, e.g. implement an undo
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // Not used, details on text at the point change made
        }
    }
}
