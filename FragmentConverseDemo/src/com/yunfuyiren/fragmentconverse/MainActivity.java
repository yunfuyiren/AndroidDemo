package com.yunfuyiren.fragmentconverse;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
    /** 
     * This is a secondary activity, to show what the user has selected 
     * when the screen is not large enough to show it all in one activity. 
     */  
	public class DetailsActivity extends Activity{
		@Override
		protected void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			
			if(getResources().getConfiguration().orientation
					==Configuration.ORIENTATION_LANDSCAPE){
				// If the screen is now in landscape mode(ºáÆÁÄ£Ê½), we can show the  
                // dialog in-line with the list so we don't need this activity.
				finish();
				return ;
			}
			if(savedInstanceState==null)
			{
				// During initial setup, plug in the details fragment.
				DetailsFragment details=new DetailsFragment();
				details.setArguments(getIntent().getExtras());
				getFragmentManager().beginTransaction().
				add(android.R.id.content, details).commit();
				//android.R.id.content gives you the root element of a view, 
				//without having to know its actual name/type/ID
			}
			


		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
