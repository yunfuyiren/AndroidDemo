package com.yunfuyiren.fragment_tabhostdemo;

import android.content.Context;
import android.view.View;
import android.widget.TabHost.TabContentFactory;

//TabContentFactory��TabActivity�ṩ�����ǵ�һ���ӿڣ�
//���ǿ�����createTabContent�����д��������Լ���view
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
