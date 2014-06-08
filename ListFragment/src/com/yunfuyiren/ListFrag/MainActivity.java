package com.yunfuyiren.ListFrag;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.yunfuyiren.listfragment.R;
public class MainActivity extends FragmentActivity{
	FragmentTransaction ft;
	TitlesFragment titlesFragment;
	DetailsFragment detailsFragment;
	
	@SuppressLint("CommitTransaction")
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		FragmentManager fm =getSupportFragmentManager();
		titlesFragment=(TitlesFragment)fm.findFragmentByTag("titles");
		detailsFragment=(DetailsFragment)fm.findFragmentByTag("details");
		ft=fm.beginTransaction();
		if(titlesFragment==null)
			ft.add(R.id.main, titlesFragment, "titles");
		if(detailsFragment==null)
			ft.add(R.id.main, detailsFragment, "details");
		ft.commit();
	}	
	
}
