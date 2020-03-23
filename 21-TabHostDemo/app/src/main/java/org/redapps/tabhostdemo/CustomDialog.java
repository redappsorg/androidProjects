package org.redapps.tabhostdemo;

import android.app.Dialog;
import android.content.Context;
import android.widget.TabHost;

class CustomDialog extends Dialog {

    CustomDialog(final Context context) {
        super(context);

        setTitle("My Custom Tabbed Dialog");
        setContentView(R.layout.custom_dialog_layout);

        TabHost tabHost = (TabHost) findViewById(R.id.TabHost01);
        tabHost.setup();

        TabHost.TabSpec firstTabSpec = tabHost.newTabSpec("firstTabSpec");
        firstTabSpec.setIndicator("Part 1");
        firstTabSpec.setContent(R.id.TextView01);
        tabHost.addTab(firstTabSpec);

        TabHost.TabSpec secondTabSpec = tabHost.newTabSpec("secondTabSpec");
        secondTabSpec.setIndicator("Part Deux");
        secondTabSpec.setContent(R.id.TextView02);
        tabHost.addTab(secondTabSpec);
    }
}
