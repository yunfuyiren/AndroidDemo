package com.example.fftestcase;

import com.example.fftest.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class Frag2 extends Fragment{
	private Button backBtn;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	 @Override  
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
			 Bundle savedInstanceState) { 
		View v=LayoutInflater.from(getActivity())
				.inflate(R.layout.frag2, null);
		backBtn=(Button)v.findViewById(R.id.back_button);
		backBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				changeTo();
			}	
		});
	    return v; 
	 }   
	 
	 private void changeTo(){
		//切换fragement
		Fragment from = null,to = null;
		String toTag = "";
		//from是当前Fragment，to是要切换的Fragment
		from=MainActivity.childFm.findFragmentByTag("OneItem");
		if((to=MainActivity.childFm.findFragmentByTag("界面1"))==null)
			to=new Frag1();
		toTag="界面1";
		MainActivity.switchContent(from, to, toTag);
	 }
}
