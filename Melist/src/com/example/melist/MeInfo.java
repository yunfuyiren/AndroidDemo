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
				builder.setMessage("���û�������");
				builder.setTitle("��ʾ");
				builder.setPositiveButton("ȷ��", new OnClickListener(){

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
		map.put("Title","���");
		map.put("Content", "��Уѧ��");
		listItem.add(map);  
		map=new HashMap<String,Object>();
		map.put("Title","������");
		map.put("Content","436");
		listItem.add(map);
		map=new HashMap<String,Object>();
		map.put("Title", "������");
		map.put("Content","36");
		listItem.add(map);  
		map=new HashMap<String,Object>();
		map.put("Title","����");
		map.put("Content", "847");
		listItem.add(map);  
		map=new HashMap<String,Object>();
		map.put("Title","�ϴε�¼ʱ��");
		map.put("Content","2014��05��11��17:39:39 ������");
		listItem.add(map);  
		map=new HashMap<String,Object>();
		map.put("Title","�ϴε�¼IP");
		map.put("Content","202.38.79.80");
		listItem.add(map);
		map=new HashMap<String,Object>();
		map.put("Title","����˵����");
		map.put("Content","û�и���˵��");
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
