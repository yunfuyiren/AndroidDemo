package com.yunfuyiren.fragmentbag22;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunfuyiren.fragmentdemo.R;

public class TranDFragment extends Fragment {
	FragmentManager fm;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.activity_main, container,false);
		TransactionFrag1 tf1=new TransactionFrag1();
		TransactionFrag2 tf2=new TransactionFrag2();

		fm=getChildFragmentManager();
		FragmentTransaction ft=fm.beginTransaction();
		if(fm.findFragmentByTag("tranDf1")==null)
		{	
			
			ft.add(R.layout.activity_main, tf1, "tranDf1");
		}
		if(fm.findFragmentByTag("tranDf2")==null)
		{			
			ft.add(R.layout.activity_main, tf2, "tranDf2");
		}
		ft.commit();
		return v;
	}
}
