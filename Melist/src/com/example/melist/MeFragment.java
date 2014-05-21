package com.example.melist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MeFragment extends Fragment {
	public static final String TAG = "MeFragment";
//	private TextView meLife;
//	private TextView meArticles;
//	private TextView meLastLoginTime;
//	private TextView meLastLoginIp;
//	private TextView meInfo;
//	private ListView meRecent;
	
	//################王洋#################
	private ListView myList;
	private String url;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.v(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		url="http://bbs.ustc.edu.cn/cgi/bbsqry?userid=icewing"; 
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.v(TAG, "onCreateView");
		View v = LayoutInflater.from(getActivity()).inflate(R.layout.me_list,null);
		
//		meLife = (TextView) v.findViewById(R.id.me_life);
//		meArticles = (TextView) v.findViewById(R.id.me_articles);
//		meLastLoginTime = (TextView) v.findViewById(R.id.me_lastlogintime);
//		meLastLoginIp = (TextView) v.findViewById(R.id.me_lastloginIP);
//		meInfo = (TextView) v.findViewById(R.id.me_info);
//		meRecent = (ListView) v.findViewById(R.id.me_recent_listview);
		
		//###################王洋############
		myList=(ListView)v.findViewById(R.id.MeListView);
		//生成动态数组，加入数据  
		ArrayList<HashMap<String,Object>> listItem=new ArrayList<HashMap<String,Object>> ();
		MeInfo mee=new MeInfo(getActivity(),url,listItem);	
		mee.execute();
		//生成适配器的Item和动态数组对应的元素  
		SimpleAdapter listItemAdapter=new SimpleAdapter(getActivity(),listItem,//数据源
		R.layout.me_list_item,//ListItem的XML实现
		//动态数组与ImageItem对应的子项   
		new String[] {"Title","Content"},
		//ImageItem的XML文件里面的Item的ID
		new int[] {R.id.MeTitleItem,R.id.MeContentItem}
		);
		myList.setAdapter(listItemAdapter);	
		return v;
	}
	
}
