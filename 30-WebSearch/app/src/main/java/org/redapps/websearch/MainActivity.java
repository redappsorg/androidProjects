package org.redapps.websearch;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //attach an instance of HandleClick to the Button
        findViewById(R.id.imageButton).setOnClickListener(new HandleClick());
    }
    private class HandleClick implements View.OnClickListener {
        public void onClick(View arg0) {
            String searchFor = ((EditText) findViewById(R.id.editText)).getText().toString();
            Intent viewSearch = new Intent(Intent.ACTION_WEB_SEARCH);
            viewSearch.putExtra(SearchManager.QUERY, searchFor);
            startActivity(viewSearch);
        }
    }
}
