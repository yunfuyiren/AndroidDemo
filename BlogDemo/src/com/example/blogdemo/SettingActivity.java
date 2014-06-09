//package com.example.blogdemo;
//
//import android.app.AlertDialog;
//import android.app.ProgressDialog;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.DialogInterface.OnClickListener;
//import android.content.DialogInterface.OnMultiChoiceClickListener;
//import android.content.SharedPreferences;
//import android.content.pm.ActivityInfo;
//import android.content.res.Configuration;
//import android.content.res.Resources;
//import android.os.Bundle;
//import android.preference.CheckBoxPreference;
//import android.preference.ListPreference;
//import android.preference.Preference;
//import android.preference.Preference.OnPreferenceClickListener;
//import android.preference.PreferenceActivity;
//import android.preference.PreferenceScreen;
//
///*PreferencesActivity是Android中专门用来实现程序
//设置界面及参数存储的一个Activity，我们用一个实例来简介
//如何使用PreferencesActivity*/
///**
// * @author wang
// * 设置
// */
//public class SettingActivity extends PreferenceActivity	
//	implements 
//		OnPreferenceClickListener,
//		OnClickListener,
//		OnMultiChoiceClickListener,
//		Preference.OnPreferenceChangeListener {
//	// preference key
//	private static final String CONFIG_ABOUT_OPTION_KEY = "config_about";// 关于
//	private static final String CONFIG_UPDATE_OPTION_KEY = "config_update";// 更新版本
//	private static final String CONFIG_READ_MODE_OPTION_KEY = "config_read_mode";// 阅读模式
//	private static final String CONFIG_IS_HORIZONTAL = "config_is_horizontal";// 是否允许横竖屏
//	private static final String CONFIG_CLEAR_CACHE = "config_clear_cache";// 清空缓存
//	
//	// Dialog id
//	private static final int DIALOG_READ_MODE_GUID = 0;// 阅读模式对话框
//	private static final int DIALOG_CLEAR_CACHE = 1;// 清空缓存对话框
//	private static final String itemPicMode = "0";// 图文模式
//	
//	ProgressDialog progressDialog;// 更新版本时进度框
//
//	private ListPreference listReadMode;// 阅读模式
//	private CheckBoxPreference listIsHorizontal;// 是否横屏
//	static Resources res;// 资源
//	
//	private AlertDialog dialogSelectReadMode;// 对话框
//	static SharedPreferences sharePreferences;// 设置
//	PreferenceScreen preferencescreen;
//	
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		addPreferencesFromResource(R.xml.preference);
//
//		res = this.getResources();
//		// 绑定点击
//		preferencescreen = getPreferenceScreen();
//		preferencescreen.findPreference(CONFIG_ABOUT_OPTION_KEY)
//				.setOnPreferenceClickListener(this);
//		// 检查更新点击监听
//		preferencescreen.findPreference(CONFIG_UPDATE_OPTION_KEY)
//				.setOnPreferenceClickListener(this);
//		// 允许横竖屏
//		preferencescreen.findPreference(CONFIG_IS_HORIZONTAL)
//				.setOnPreferenceClickListener(this);
//		listIsHorizontal = (CheckBoxPreference) findPreference(CONFIG_IS_HORIZONTAL);
//
//		// 读取阅读模式
//		preferencescreen.findPreference(CONFIG_READ_MODE_OPTION_KEY)
//				.setOnPreferenceChangeListener(this);
//		// 清空缓存
//		preferencescreen.findPreference(CONFIG_CLEAR_CACHE)
//				.setOnPreferenceClickListener(this);
//		listReadMode = (ListPreference) findPreference(CONFIG_READ_MODE_OPTION_KEY);
//
//		//得到模式阅读模式，默认返回"0"
//		String readMode = GetConfigReadMode(getApplicationContext());
//		listReadMode.setSummary("当前选择：" + GetReadMode(readMode));
//
//		sharePreferences = GetDefaultSharedPreferences(this);
//
//		BindControls();
//	}
//	private String GetReadMode(String mode) {
//		// TODO Auto-generated method stub
//		return mode.equalsIgnoreCase(itemPicMode) ? "图文模式" : "文本模式";
//	}
//	private String GetConfigReadMode(Context applicationContext) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	/**
//	 * 设置初始状态
//	 */
//	private void BindControls() {
//		// TODO Auto-generated method stub
//		boolean isHorizontal = getIsAutoHorizontal(getApplicationContext());
//		//CheckBoxPreference.setSelectable作用：Sets whether this Preference is selectable
//		//如果不是横屏，设置不可点击
//		listIsHorizontal.setSelectable(isHorizontal);
//	}
//	private boolean getIsAutoHorizontal(Context applicationContext) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	
//	/* 安卓API解释
//	 * Called by the system when the device configuration changes while your activity is running. 
//	 * Note that this will only be called if you have selected configurations you would like to handle with the configChanges attribute in your manifest. 
//	 * If any configuration change occurs that is not selected to be reported by that attribute, then instead of reporting it the system will stop and restart the activity (to have it launched with the new configuration). 
//	 */
//	@Override
//	public void onConfigurationChanged(Configuration newConfig) {
//		super.onConfigurationChanged(newConfig);
//	}
//	
//	/**
//	 * 横竖屏
//	 */
//	@Override
//	protected void onResume() {
//		super.onResume();
//		if (!getIsAutoHorizontal(this))//如果true，则是显式的设置了为竖屏
//			/*
//			 * 通过setRequestedOrientation(xxx)方法设置指定方向后，Activity将不再自动根据物理传感器进行横竖屏切换.
//			 * 若要恢复，再调用setRequestedOrientation(UNSPECIFIED)即可。
//			 */
//			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//		else
//			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER);
//	}
//	
//	/**
//	 * 得到默认的sharedPreferences
//	 * 
//	 * @return
//	 */
//	private SharedPreferences GetDefaultSharedPreferences(
//			Context context) {
//		// TODO Auto-generated method stub
//		return context.getSharedPreferences(
//				context.getResources().getString(R.string.preferences_key),
//				MODE_PRIVATE);
//	}
//	@Override
//	public boolean onPreferenceChange(Preference arg0, Object arg1) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public void onClick(DialogInterface arg0, int arg1, boolean arg2) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onClick(DialogInterface arg0, int arg1) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public boolean onPreferenceClick(Preference arg0) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//}
