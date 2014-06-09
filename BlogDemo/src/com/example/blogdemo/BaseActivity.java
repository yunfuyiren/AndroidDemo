package com.example.blogdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

/**
 * @author wang
 * ���࣬�󲿷�Activity�̳��Դ���
 */
public class BaseActivity extends Activity{
	/**
	 * ������
	 */
	@Override
	protected void onResume() {
		super.onResume();
		//���á����á��࣬
	}
	protected void onPause() {
		super.onPause();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	/**
	 * ���¼����Ϸ��ذ�ť
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_SEARCH){//����
			Intent intent = new Intent(BaseActivity.this,SearchActivity.class);
			intent.putExtra("isShowQuitHints", false);
			startActivity(intent);
			return true;
		}else {		
			return super.onKeyDown(keyCode, event);
		}
	}
}
