package com.yunfuyiren.fragmentbag22;

import com.yunfuyiren.fragmentdemo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NestFrameByAdd extends Fragment{
	static FragmentManager childFm;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.nestframe, container,false);
		NestedFragmentByAdd f=new NestedFragmentByAdd();
		childFm=getChildFragmentManager();
		childFm.beginTransaction().add(R.id.nest_frame, f, "0").commit();
		return v;
	}
}
