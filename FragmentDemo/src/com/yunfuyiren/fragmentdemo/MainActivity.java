package com.yunfuyiren.fragmentdemo;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
//import android.app.Fragment;
//import android.app.FragmentManager;
//import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.yunfuyiren.fragmentbag22.*;

public class MainActivity extends FragmentActivity {
	private static FragmentManager fm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fm=getSupportFragmentManager();
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

		private ListView listview; //菜单显示
		private SimpleAdapter adapter;  //菜单数据适配器
		public static Fragment fme;
		public PlaceholderFragment() {
			
		}
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);	
			fme=this;
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
			
			listview.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					if(position==0)
					{
						if(fm.findFragmentByTag("0")==null)
						{
//							Toast.makeText(getActivity(), "0", Toast.LENGTH_LONG).show();
							CreateStaticFragment f0=new CreateStaticFragment();		
							MainActivity.switchContent(fme, f0, "0");
						}
					}
				}
			});
		
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
	
	public static void switchContent(Fragment from,Fragment to,String toTag){
		if(from!=to){
			FragmentTransaction transaction=fm.beginTransaction();
			transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
			if(!to.isAdded()){
				transaction.hide(from).add(R.id.container, to,toTag).commit();
			}else{
				transaction.hide(from).show(to).commit();
			}
		}
	
	}
}
