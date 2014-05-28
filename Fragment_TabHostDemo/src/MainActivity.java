

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.TabHost;

import com.yunfuyiren.fragment_tabhostdemo.R;


public class MainActivity extends FragmentActivity{
	TabHost tHost;
	@Override 
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tHost=(TabHost)findViewById(android.R.id.tabhost);
		tHost.setup();
		
		 /** Defining Tab Change Listener event. This is invoked when tab is changed */
		TabHost.OnTabChangeListener tabChangeListener= new TabHost.OnTabChangeListener() {
			
			@Override
			public void onTabChanged(String tabId) {
				// TODO Auto-generated method stub
				FragmentManager fm =getSupportFragmentManager();
				AndroidFragment androidFragment = (AndroidFragment) fm.findFragmentByTag("android");
				AppleFragment appleFragment = (AppleFragment) fm.findFragmentByTag("apple");
				
				FragmentTransaction ft=fm.beginTransaction();
				 /** Detaches the androidfragment if exists */
				if(androidFragment!=null)
					ft.detach(androidFragment);
			}
		};
	}
}
