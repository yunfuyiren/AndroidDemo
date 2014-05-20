package com.yunfuyiren.fragmentbag22;

import com.yunfuyiren.fragmentdemo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CreateDynamicFragment extends Fragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view=inflater.inflate(R.layout.dynamicfrag, container, false);  
		CreatedFrag f=new CreatedFrag();
		FragmentManager fm=getChildFragmentManager();
		fm.beginTransaction().add(R.id.dynamicfrag, f, "dynamical").commit();

		return view;
	}
}
