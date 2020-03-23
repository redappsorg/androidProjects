package org.redapps.emailtextview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

	private Button emailButton;
	private EditText emailText;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Set the View Layer
		setContentView(R.layout.activity_main);

		// Get reference to Email Button
		emailButton = (Button) this.findViewById(R.id.email_button);

		// Sets the Event Listener onClick
		emailButton.setOnClickListener(this);

		emailText = (EditText) findViewById(R.id.text_to_send);
	}

	@Override
	public void onClick(View view) {

		Intent emailIntent = new Intent(Intent.ACTION_SEND);
		emailIntent.setType("text/html");
		emailIntent.putExtra(Intent.EXTRA_TITLE, "My Title");
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, "My Subject");

		// Obtain reference to String and pass it to Intent
		emailIntent.putExtra(Intent.EXTRA_TEXT, emailText.getText());

		// Start the user's email client.
		startActivity(emailIntent);
	}
}
