package com.yunfuyiren.fragmentbag22;

import com.yunfuyiren.fragmentdemo.R;



//import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CreateStaticFragment extends Fragment{
	private static View view;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		   if (view != null) {
		        ViewGroup parent = (ViewGroup) view.getParent();
		        if (parent != null)
		            parent.removeView(view);
		    }
		    try {
		        view = inflater.inflate(R.layout.staticfrag, container, false);
		    } catch (InflateException e) {
		        /* map is already there, just return view as it is */
		    }
				
		return view;
	}
}
