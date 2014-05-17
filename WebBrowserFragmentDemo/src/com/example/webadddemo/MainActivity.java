package com.example.webadddemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
	public PageFragment pf;
	long exitTime=0;   //˫���˳���ʱ
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        FragmentManager fm=getSupportFragmentManager();
        pf=new PageFragment();
        fm.beginTransaction().add(R.id.main_layout,pf, "webpage").commit();
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)  {
		
		 if(keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0)  
         {  
	    
	        if((System.currentTimeMillis()-exitTime) > 2000)  //System.currentTimeMillis()���ۺ�ʱ���ã��϶�����2000  
	        {  
	               Toast.makeText(getApplicationContext(), "�ٰ�һ���˳�����",Toast.LENGTH_SHORT).show();                   
	               exitTime = System.currentTimeMillis();  
	               return pf.onKeyDown(keyCode, event);
	        }  
	        else  
	        {  
	            return super.onKeyDown(keyCode, event);//super.onKeyDown(keyCode, event);
	        }  
	       
         }
		 return super.onKeyDown(keyCode, event);   
	}
	//���˼�
//	@Override
//	public void onBackPressed(){
//		pf.onBackPressed();
//	}
}
