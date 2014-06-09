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
///*PreferencesActivity��Android��ר������ʵ�ֳ���
//���ý��漰�����洢��һ��Activity��������һ��ʵ�������
//���ʹ��PreferencesActivity*/
///**
// * @author wang
// * ����
// */
//public class SettingActivity extends PreferenceActivity	
//	implements 
//		OnPreferenceClickListener,
//		OnClickListener,
//		OnMultiChoiceClickListener,
//		Preference.OnPreferenceChangeListener {
//	// preference key
//	private static final String CONFIG_ABOUT_OPTION_KEY = "config_about";// ����
//	private static final String CONFIG_UPDATE_OPTION_KEY = "config_update";// ���°汾
//	private static final String CONFIG_READ_MODE_OPTION_KEY = "config_read_mode";// �Ķ�ģʽ
//	private static final String CONFIG_IS_HORIZONTAL = "config_is_horizontal";// �Ƿ����������
//	private static final String CONFIG_CLEAR_CACHE = "config_clear_cache";// ��ջ���
//	
//	// Dialog id
//	private static final int DIALOG_READ_MODE_GUID = 0;// �Ķ�ģʽ�Ի���
//	private static final int DIALOG_CLEAR_CACHE = 1;// ��ջ���Ի���
//	private static final String itemPicMode = "0";// ͼ��ģʽ
//	
//	ProgressDialog progressDialog;// ���°汾ʱ���ȿ�
//
//	private ListPreference listReadMode;// �Ķ�ģʽ
//	private CheckBoxPreference listIsHorizontal;// �Ƿ����
//	static Resources res;// ��Դ
//	
//	private AlertDialog dialogSelectReadMode;// �Ի���
//	static SharedPreferences sharePreferences;// ����
//	PreferenceScreen preferencescreen;
//	
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		addPreferencesFromResource(R.xml.preference);
//
//		res = this.getResources();
//		// �󶨵��
//		preferencescreen = getPreferenceScreen();
//		preferencescreen.findPreference(CONFIG_ABOUT_OPTION_KEY)
//				.setOnPreferenceClickListener(this);
//		// �����µ������
//		preferencescreen.findPreference(CONFIG_UPDATE_OPTION_KEY)
//				.setOnPreferenceClickListener(this);
//		// ���������
//		preferencescreen.findPreference(CONFIG_IS_HORIZONTAL)
//				.setOnPreferenceClickListener(this);
//		listIsHorizontal = (CheckBoxPreference) findPreference(CONFIG_IS_HORIZONTAL);
//
//		// ��ȡ�Ķ�ģʽ
//		preferencescreen.findPreference(CONFIG_READ_MODE_OPTION_KEY)
//				.setOnPreferenceChangeListener(this);
//		// ��ջ���
//		preferencescreen.findPreference(CONFIG_CLEAR_CACHE)
//				.setOnPreferenceClickListener(this);
//		listReadMode = (ListPreference) findPreference(CONFIG_READ_MODE_OPTION_KEY);
//
//		//�õ�ģʽ�Ķ�ģʽ��Ĭ�Ϸ���"0"
//		String readMode = GetConfigReadMode(getApplicationContext());
//		listReadMode.setSummary("��ǰѡ��" + GetReadMode(readMode));
//
//		sharePreferences = GetDefaultSharedPreferences(this);
//
//		BindControls();
//	}
//	private String GetReadMode(String mode) {
//		// TODO Auto-generated method stub
//		return mode.equalsIgnoreCase(itemPicMode) ? "ͼ��ģʽ" : "�ı�ģʽ";
//	}
//	private String GetConfigReadMode(Context applicationContext) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	/**
//	 * ���ó�ʼ״̬
//	 */
//	private void BindControls() {
//		// TODO Auto-generated method stub
//		boolean isHorizontal = getIsAutoHorizontal(getApplicationContext());
//		//CheckBoxPreference.setSelectable���ã�Sets whether this Preference is selectable
//		//������Ǻ��������ò��ɵ��
//		listIsHorizontal.setSelectable(isHorizontal);
//	}
//	private boolean getIsAutoHorizontal(Context applicationContext) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	
//	/* ��׿API����
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
//	 * ������
//	 */
//	@Override
//	protected void onResume() {
//		super.onResume();
//		if (!getIsAutoHorizontal(this))//���true��������ʽ��������Ϊ����
//			/*
//			 * ͨ��setRequestedOrientation(xxx)��������ָ�������Activity�������Զ����������������к������л�.
//			 * ��Ҫ�ָ����ٵ���setRequestedOrientation(UNSPECIFIED)���ɡ�
//			 */
//			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//		else
//			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER);
//	}
//	
//	/**
//	 * �õ�Ĭ�ϵ�sharedPreferences
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
