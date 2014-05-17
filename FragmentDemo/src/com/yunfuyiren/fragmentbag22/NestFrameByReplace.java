package com.yunfuyiren.fragmentbag22;

import com.yunfuyiren.fragmentdemo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NestFrameByReplace extends Fragment {
	public static FragmentManager nFm;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View v=inflater.inflate(R.layout.nestframe, container,false);
		nFm=getChildFragmentManager();
		NestedFragmentByReplace.FragNum=0;
		NestedFragmentByReplace nF=new NestedFragmentByReplace();
		nFm.beginTransaction().replace(R.id.nest_frame, nF,"0")
		.addToBackStack(null).commit();
		return v;
	}
	
	
}
