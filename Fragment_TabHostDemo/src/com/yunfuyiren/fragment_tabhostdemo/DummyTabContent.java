package com.yunfuyiren.fragment_tabhostdemo;

import android.content.Context;
import android.view.View;
import android.widget.TabHost.TabContentFactory;

//TabContentFactory是TabActivity提供给我们的一个接口，
//我们可以在createTabContent方法中创建我们自己的view
public class DummyTabContent implements TabContentFactory{
	private Context mContext;
	
	public DummyTabContent(Context context){
		mContext=context;
	}
	@Override
	public View createTabContent(String tag) {
		// TODO Auto-generated method stub
		View v=new View(mContext);
		return v;
	}
	
}
