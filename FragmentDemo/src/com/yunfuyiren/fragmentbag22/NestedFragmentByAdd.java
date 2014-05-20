package com.yunfuyiren.fragmentbag22;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.yunfuyiren.fragmentdemo.R;

public class NestedFragmentByAdd extends Fragment{
	public static int FNum;
	private NestedFragmentByAdd fme;
	public NestedFragmentByAdd()
	{
		fme=this;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View v=inflater.inflate(R.layout.nestedfrag, container,false);	
		Button btn=(Button)v.findViewById(R.id.NestedButton);
		TextView tv=(TextView)v.findViewById(R.id.NestedText);
		String s=FNum+"";
		tv.setText("This is the "+s+" nested Fragment by add");
		btn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				FNum++;
				String s=FNum+"";
				NestedFragmentByAdd f;
				if(NestFrameByAdd.childFm.findFragmentByTag(s)==null)
				{
					f=new NestedFragmentByAdd();
					FragmentTransaction ft=NestFrameByAdd.childFm.beginTransaction();					
					ft.hide(fme).add(R.id.nest_frame, f, s).commit();
				}else
				{
					FragmentTransaction ft=NestFrameByAdd.childFm.beginTransaction();	
					ft.show(NestFrameByAdd.childFm.findFragmentByTag(s)).commit();
					
				}
			}
			
		});	
		return v;
	}
}
