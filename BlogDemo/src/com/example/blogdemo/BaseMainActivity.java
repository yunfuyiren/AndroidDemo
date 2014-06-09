package com.example.blogdemo;

import android.app.AlertDialog;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * @author wang
 * 五个tab主Activity继承此Activity
 */
public class BaseMainActivity extends BaseActivity{
	private static final int DIALOG_OFFLINE_DOWNLOAD_GUID = 0;// 离线下载
	private AlertDialog dialogOfflineDownload;// 对话框
	
	TextView tvSeekBar;// SeekBar显示文本框
	SeekBar seekBar;// SeekBar
	CheckBox chkBlog;// 下载博客
	CheckBox chkNews;// 下载新闻
	
	public boolean IsShowQuitHints=true;
	/**
	 * 按下键盘上返回按钮
	 */
//	public boolean onKeyDown(int keyCode, KeyEvent event) {
//		if (keyCode == KeyEvent.KEYCODE_BACK && IsShowQuitHints) {//后退
//			AppUtil.QuitHintDialog(this);
//
//			return true;
//		}else if(keyCode==KeyEvent.KEYCODE_SEARCH){//搜索
//			Intent intent = new Intent(BaseMainActivity.this,SearchActivity.class);
//			intent.putExtra("isShowQuitHints", false);
//			startActivity(intent);
//			return true;
//		}else {		
//			return super.onKeyDown(keyCode, event);
//		}
//	}
}
