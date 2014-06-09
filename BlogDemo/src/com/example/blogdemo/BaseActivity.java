package com.example.blogdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

/**
 * @author wang
 * 基类，大部分Activity继承自此类
 */
public class BaseActivity extends Activity{
	/**
	 * 横竖屏
	 */
	@Override
	protected void onResume() {
		super.onResume();
		//设置“设置”类，
	}
	protected void onPause() {
		super.onPause();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	/**
	 * 按下键盘上返回按钮
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_SEARCH){//搜索
			Intent intent = new Intent(BaseActivity.this,SearchActivity.class);
			intent.putExtra("isShowQuitHints", false);
			startActivity(intent);
			return true;
		}else {		
			return super.onKeyDown(keyCode, event);
		}
	}
}
