package com.yunfuyiren.fragmentbag22;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yunfuyiren.fragmentdemo.R;

public class TransactionFrag1 extends Fragment{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.tran_subfrag, container,false);
		TextView tv=(TextView)v.findViewById(R.id.talkfrom);
		EditText et=(EditText)v.findViewById(R.id.talkcontent);
		Button btn=(Button)v.findViewById(R.id.talkbutton);
		return v;
	}
}
