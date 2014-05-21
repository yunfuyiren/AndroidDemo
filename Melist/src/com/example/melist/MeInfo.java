package com.example.melist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;


public class MeInfo extends AsyncTask<Void,Void,Void>{
	private String url;
	private Document doc;
	private ArrayList<HashMap<String,Object>> listItem;
	private Context cxt;
	public MeInfo()
	{
		url="";
		
	}
	public MeInfo(Context cxt,String url,ArrayList<HashMap<String,Object>> listItem)
	{
		this.url=url;
		this.listItem=listItem;
		this.cxt=cxt;
	}
	
	@Override
	protected Void doInBackground(Void... arg0) {
		// TODO Auto-generated method stub	
		try {
			doc=Jsoup.connect(url).get();
			if(doc==null)
			{
				AlertDialog.Builder builder=new Builder(this.cxt);
				builder.setMessage("该用户不存在");
				builder.setTitle("提示");
				builder.setPositiveButton("确认", new OnClickListener(){

					@Override
					public void onClick(DialogInterface  dialog, int  which) {
						// TODO Auto-generated method stub
						dialog.dismiss();
					}		
				});
				builder.create().show();
			}else
			{
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<String,Object> map=new HashMap<String,Object>();  
		map.put("Title","身份");
		map.put("Content", "本校学生");
		listItem.add(map);  
		map=new HashMap<String,Object>();
		map.put("Title","生命力");
		map.put("Content","436");
		listItem.add(map);
		map=new HashMap<String,Object>();
		map.put("Title", "文章数");
		map.put("Content","36");
		listItem.add(map);  
		map=new HashMap<String,Object>();
		map.put("Title","网龄");
		map.put("Content", "847");
		listItem.add(map);  
		map=new HashMap<String,Object>();
		map.put("Title","上次登录时间");
		map.put("Content","2014年05月11日17:39:39 星期日");
		listItem.add(map);  
		map=new HashMap<String,Object>();
		map.put("Title","上次登录IP");
		map.put("Content","202.38.79.80");
		listItem.add(map);
		map=new HashMap<String,Object>();
		map.put("Title","个人说明档");
		map.put("Content","没有个人说明");
		listItem.add(map);  
		return null;
	}
	@Override
	protected void onPostExecute(Void result) {
	        // TODO Auto-generated method stub
	        super.onPostExecute(result);
	        // Here you can do any UI operations like textview.setText("test");
	}
}
