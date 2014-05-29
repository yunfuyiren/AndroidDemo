package com.yunfuyiren.blogdemo;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TabHost;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		private TabHost tHost;
		private RadioButton rbBlog;
		private RadioButton rbNews;
		private RadioButton rbRss;
		private RadioButton rbSearch;
		private RadioButton rbMore;
		
		public String whichTab = "";// 当前选中Tab
		
		Resources res;// 资源
		public PlaceholderFragment() {
		}
	
		private void InitialTab() {
			// TODO Auto-generated method stub
			
		}
		/**
		 * 初始化单选按钮
		 *
		 */ 
		private void InitialRadios() {
			// TODO Auto-generated method stub
			rbBlog=(RadioButton)this.getView().findViewById(R.id.TabBlog);
//			rbBlog.setOnClickListener();
			rbNews=(RadioButton)this.getView().findViewById(R.id.TabNews);
			rbRss=(RadioButton)this.getView().findViewById(R.id.TabRss);
			rbSearch=(RadioButton)this.getView().findViewById(R.id.TabSearch);
			rbMore=(RadioButton)this.getView().findViewById(R.id.TabMore);
		
		}
		
		@Override
		public void onCreate(Bundle savedInstanceState)
		{	
			super.onCreate(savedInstanceState);
			res=this.getResources();
		}
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			InitialRadios();
			InitialTab();
			return rootView;
		}
	}
}
