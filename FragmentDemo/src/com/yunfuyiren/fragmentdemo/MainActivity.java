package com.yunfuyiren.fragmentdemo;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
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

		private ListView listview; //菜单显示
		private SimpleAdapter adapter;  //菜单数据适配器
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			listview=(ListView)rootView.findViewById(R.id.mainlist);
			adapter=new SimpleAdapter(getActivity(),getData(),R.layout.list_item,
					new String[]{"Image","Title"}, new int[]{R.id.img,R.id.title});
			listview.setAdapter(adapter);
			return rootView;
		}
	
		
		private ArrayList<HashMap<String,Object>> getData(){
			ArrayList<HashMap<String,Object>> dlist=new ArrayList<HashMap<String,Object>>();
			HashMap<String,Object> map=new HashMap<String,Object>();
			map.put("Image", R.drawable.pic);
			map.put("Title", "Creating a static fragment");
			dlist.add(map);
			map=new HashMap<String,Object>();
			map.put("Image", R.drawable.pic);
			map.put("Title", "Creating a dynamic fragment");
			dlist.add(map);
			map=new HashMap<String,Object>();
			map.put("Image", R.drawable.pic);
			map.put("Title", "Nested fragment with transaction:replace");
			dlist.add(map);
			map=new HashMap<String,Object>();
			map.put("Image", R.drawable.pic);
			map.put("Title", "Nested fragment with transaction:add");
			dlist.add(map);
			map=new HashMap<String,Object>();
			map.put("Image", R.drawable.pic);
			map.put("Title","Fragments communication");
			dlist.add(map);
			return dlist;
		}
	}

}
