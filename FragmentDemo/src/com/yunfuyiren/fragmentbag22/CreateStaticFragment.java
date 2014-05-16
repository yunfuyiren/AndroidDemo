package com.yunfuyiren.fragmentbag22;

import com.yunfuyiren.fragmentdemo.R;


//import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CreateStaticFragment extends Fragment{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
//		View v=LayoutInflater.from(getActivity()).inflate(R.layout.staticfrag, null);		
		return inflater.inflate(R.layout.staticfrag, container,false);
	}
}
