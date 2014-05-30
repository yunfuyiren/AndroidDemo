package com.yunfuyiren.fragment_tabhostdemo2;

import android.content.Context;
import android.view.View;
import android.widget.TabHost.TabContentFactory;

public class DummyTabContent implements TabContentFactory{
	private Context mContext;	
	public DummyTabContent(Context context){
		mContext = context;
	}
	@Override
	public View createTabContent(String arg0) {
		// TODO Auto-generated method stub
		View v = new View(mContext);
		return v;
	}
}
