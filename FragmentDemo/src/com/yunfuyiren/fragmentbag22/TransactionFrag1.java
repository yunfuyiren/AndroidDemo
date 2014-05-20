package com.yunfuyiren.fragmentbag22;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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
		View v=inflater.inflate(R.layout.tran_subfrag1, container,false);
		final EditText et=(EditText)v.findViewById(R.id.talkcontent1);
		Button btn=(Button)v.findViewById(R.id.talkbutton1);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String content=et.getText().toString();
				if(content!=null&&content!= "")
				{
					TransactionFrag2 tf2=(TransactionFrag2)getFragmentManager().findFragmentById(R.id.tfrag2);
					TextView tv2=(TextView)tf2.getView().findViewById(R.id.talkfrom1);
					tv2.setText("talk frome frag2: "+content);
//					Bundle args=new Bundle();
//					args.putString("talk_title", "talkFrag1");
//					args.putCharSequence("talk_content", content);
//					setArguments(args);
				}
			}
		});
		return v;
	}
}
