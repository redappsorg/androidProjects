package org.redapps.listviewadvanced;

import android.app.ListActivity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;

public class AdvancedListViewActivity extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Context ctx = getApplicationContext();
		Resources res = ctx.getResources();

		String[] options = res.getStringArray(R.array.country_names);
		TypedArray icons = res.obtainTypedArray(R.array.country_icons);
		
		setListAdapter(new ImageAndTextAdapter(ctx, R.layout.main_list_item,
				options, icons));
    }
}