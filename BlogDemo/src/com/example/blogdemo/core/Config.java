package com.example.blogdemo.core;

import android.annotation.SuppressLint;

/**
 * @author wang
 * 配置内信息
 */
@SuppressLint("SdCardPath")
public class Config {
	public static final String TEMP_IMAGES_LOCATION = "/sdcard/BlogDemo/images/";// 临时图片文件
	
	public static final String DB_FILE_NAME="BlogDemo_db";//数据库文件名
	public static final String APP_PACKAGE_NAME="com.example.blogdemo";//程序包名
}
