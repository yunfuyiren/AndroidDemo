package com.yunfuyiren.fragmentbag22;

//import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunfuyiren.fragmentdemo.*;

public class CreatedFrag extends Fragment{
	
	  @Override  
	    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {  
//		  View v=LayoutInflater.from(getActivity()).inflate(R.layout.staticfrag, null);  
		  return inflater.inflate(R.layout.createdfrag, container, false);   
	    }  
}
