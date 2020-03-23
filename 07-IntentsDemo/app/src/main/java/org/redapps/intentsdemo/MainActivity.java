package org.redapps.intentsdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private int requestCode = 0;
	private EditText textField;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textField = (EditText)findViewById(R.id.textfield);

		Button b = (Button)findViewById(R.id.go_easy);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String uri = textField.getText().toString();
				Toast.makeText(MainActivity.this, "Starting " + uri, Toast.LENGTH_SHORT).show();
				try {
					Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
					startActivity(intent);
				} catch (Exception e) {
					Toast.makeText(MainActivity.this, "Error: " + e, Toast.LENGTH_LONG).show();
				}
			}
		});
		
		Button b2 = (Button)findViewById(R.id.go_results);
		b2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String uri = textField.getText().toString();
				Toast.makeText(MainActivity.this, "Starting " + uri, Toast.LENGTH_SHORT).show();
				try {
					Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
					startActivityForResult(intent, ++requestCode);
				} catch (Exception e) {
					Toast.makeText(MainActivity.this, "Error: " + e, Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		Toast.makeText(MainActivity.this,
				String.format("Activity %d result %d", requestCode, resultCode),
				Toast.LENGTH_LONG).show();
	}
}
