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
		if(childFm.findFragmentByTag("����1")==null)
		{
			Frag1 f1=new Frag1();	
			FragmentTransaction ft=childFm.beginTransaction();	
			ft.add(R.id.main_layout,f1,"����1").commit();
		}
	}
	public static void switchContent(Fragment from, Fragment to, String toTag) {
        if (from != to) {
            FragmentTransaction transaction = childFm.beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            if (!to.isAdded()) {    // ���ж��Ƿ�add��
                transaction.hide(from).add(R.id.main_layout, to, toTag).commit(); // ���ص�ǰ��fragment��add��һ����Activity��
            } else {
            	// ���ص�ǰ��fragment����ʾ��һ��
                transaction.hide(from).show(to).commit(); 
            }
        }
    }
}
