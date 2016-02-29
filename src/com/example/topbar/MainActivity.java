package com.example.topbar;

import com.example.topbar.TopBar.TopBarClickListener;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TopBar topBar = (TopBar) findViewById(R.id.top_bar);
        topBar.setLeftIsvisable(false);
        topBar.setOnTopBarClickListener(new TopBarClickListener() {
			
			@Override
			public void rightClick() {
				Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void leftClick() {
				Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
			}
		});
    }

}
