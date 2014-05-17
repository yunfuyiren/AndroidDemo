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

public class TransactionFrag2 extends Fragment{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.tran_subfrag, container,false);
		TextView tv=(TextView)v.findViewById(R.id.talkfrom);
		final EditText et=(EditText)v.findViewById(R.id.talkcontent);
		Button btn=(Button)v.findViewById(R.id.talkbutton);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String content=et.getText().toString();
				if(content!=null)
				{
					TransactionFrag1 tf1=(TransactionFrag1)getFragmentManager()
							.findFragmentByTag("tfrag1");
					TextView tv1=(TextView)tf1.getView().findViewWithTag("tfrag1");
					tv1.setText("talk frome frag1: "+content);
//					Bundle args=new Bundle();
//					args.putString("talk_title", "talkFrag1");
//					args.putCharSequence("talk_content", content);	
				}
			}
			
		});
		return v;
	}
}
