package com.example.blogdemo;

import android.app.AlertDialog;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * @author wang
 * ���tab��Activity�̳д�Activity
 */
public class BaseMainActivity extends BaseActivity{
	private static final int DIALOG_OFFLINE_DOWNLOAD_GUID = 0;// ��������
	private AlertDialog dialogOfflineDownload;// �Ի���
	
	TextView tvSeekBar;// SeekBar��ʾ�ı���
	SeekBar seekBar;// SeekBar
	CheckBox chkBlog;// ���ز���
	CheckBox chkNews;// ��������
	
	public boolean IsShowQuitHints=true;
	/**
	 * ���¼����Ϸ��ذ�ť
	 */
//	public boolean onKeyDown(int keyCode, KeyEvent event) {
//		if (keyCode == KeyEvent.KEYCODE_BACK && IsShowQuitHints) {//����
//			AppUtil.QuitHintDialog(this);
//
//			return true;
//		}else if(keyCode==KeyEvent.KEYCODE_SEARCH){//����
//			Intent intent = new Intent(BaseMainActivity.this,SearchActivity.class);
//			intent.putExtra("isShowQuitHints", false);
//			startActivity(intent);
//			return true;
//		}else {		
//			return super.onKeyDown(keyCode, event);
//		}
//	}
}
