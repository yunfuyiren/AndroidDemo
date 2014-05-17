package com.yunfuyiren.fragmentbag22;

import com.yunfuyiren.fragmentdemo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class NestedFragmentByReplace extends Fragment{
	public static int FragNum;
	String Fnum;
	public NestedFragmentByReplace()
	{
		
	}
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Fnum=FragNum+"";
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view=inflater.inflate(R.layout.nestedfrag, container, false);  
		
		Button btn=(Button)view.findViewById(R.id.NestedButton);
		TextView text=(TextView)view.findViewById(R.id.NestedText);	
		text.setText("This is "+Fnum+" nested fragment by replace");
		btn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				FragNum++;
				String num=FragNum+"";
				if(NestFrameByReplace.nFm.findFragmentByTag(num) == null)
				{					
					NestedFragmentByReplace f=new NestedFragmentByReplace();
					NestFrameByReplace.nFm.beginTransaction().replace(R.id.nest_frame, f, num)
					.addToBackStack(null).commit();				
				}
			}			
		});
		return view;
	}
}
