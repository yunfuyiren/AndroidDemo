package com.example.fftestcase;


import com.example.fftest.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

	public static FragmentManager childFm;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		childFm=getSupportFragmentManager();
		Toast.makeText(this, "MainActivity.oncreate()", Toast.LENGTH_SHORT).show();	
		initContent();
	}
	private void initContent(){
		setContentView(R.layout.activity_main);
		if(childFm.findFragmentByTag("界面1")==null)
		{
			Frag1 f1=new Frag1();	
			FragmentTransaction ft=childFm.beginTransaction();	
			ft.add(R.id.main_layout,f1,"界面1").commit();
		}
	}
	public static void switchContent(Fragment from, Fragment to, String toTag) {
        if (from != to) {
            FragmentTransaction transaction = childFm.beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            if (!to.isAdded()) {    // 先判断是否被add过
                transaction.hide(from).add(R.id.main_layout, to, toTag).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
            	// 隐藏当前的fragment，显示下一个
                transaction.hide(from).show(to).commit(); 
            }
        }
    }
}
