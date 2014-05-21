package com.example.fftestcase;

import com.example.fftest.*;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;


public class Frag1 extends Fragment{
	private ListAdapter adapter;
	private ListView listv;
	  @Override  
	 public void onCreate(Bundle savedInstanceState) {  
		  super.onCreate(savedInstanceState);
		  Toast.makeText(getActivity(), "Frag1.oncreate()", Toast.LENGTH_SHORT).show();	
		
	}
	  
	@Override  
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {  			
//			return inflater.inflate(R.layout.frag1, container, false);  
		  adapter=new ListAdapter(getActivity());
		  setPeople();   
		  View v=LayoutInflater.from(getActivity()).
				 inflate(R.layout.frag1,null);//先解析frag1.xml布局，得到一个view
		 listv=(ListView)v.findViewById(R.id.ListView01);
		 listv.setAdapter(adapter);
		 listv.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "The item is"+arg2, Toast.LENGTH_SHORT).show();		
			//	new LoginThread().start();
				changeTo();
			}
		 });
		 Toast.makeText(getActivity(), "Frag1.onCreateView()", Toast.LENGTH_SHORT).show();	
		 return v;
	 }  
	
	//为adapter添加值
	 public void setPeople(){  
	        People people;  
	        for(int i=1;i<10;i++){  
	            people = new People();  
	            people.name="张三";  
	            people.sex = "男";  
	            people.age ="22";  
	            adapter.addList(people);  
	        }  
	 }
	 
//	 class LoginThread extends Thread{
//		public void run(){
//			@SuppressWarnings("unused")
//			String url = "http://bbs.ustc.edu.cn/main.html";
//			Log.v("LoginThread", "aa");
//			//登录				
//		}
//	}

	private void changeTo(){
		Fragment from = null,to = null;
		String toTag = "";
		//from是当前Fragment，to是要切换的Fragment
		from = MainActivity.childFm.findFragmentByTag("界面1");
		if((to = MainActivity.childFm.findFragmentByTag("OneItem")) == null)
			to = new Frag2();
		toTag = "OneItem";
		MainActivity.switchContent(from, to, toTag);
	}
		
}
