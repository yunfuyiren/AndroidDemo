package com.example.myadapterdemo;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{
	private List<People> list=new ArrayList<People>();
	private Context context;
	private int resource;// �󶨵�һ����Ŀ�����id�������м�Ϊitem.xml
	 private LayoutInflater inflater;// �����������������ʹ��һ��xml�ļ�����һ��View���󣬿���ͨ��Context��ȡʵ������
	
	 public MyAdapter(Context context, List<People> persons, int resource) {
		  inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		  this.resource = resource;
		  this.list = persons;
	}
	 
	 public MyAdapter(Context context){  
	        this.context = context;  
	 }  
	 
	 @Override
	public int getCount() {// �õ�Ҫ�󶨵���������
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {// ��������ֵ���õ�����ֵ��Ӧ�Ķ���
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {// ��ȡ��Ŀid
		// TODO Auto-generated method stub
		return arg0;
	}
	 // ListView�л��湦�ܣ�����ʾ��һҳҳ��ʱ�ᴴ��ҳ�������ʾ�ڶ�ҳʱ���õ�һҳ�������˵Ķ���
	 // ȡ����Ŀ����:position����ǰ��Ŀ��Ҫ�󶨵������ڼ����е�����ֵ
	@Override
	public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
		// TODO Auto-generated method stub
		paramView=LayoutInflater.from(context)   // ������ͼ����������������  
				.inflate(R.layout.item, null);    // ��ȡlist_item�����ļ�����ͼ
		//ͨ��view���õ�Item��ÿ���ؼ��Ĳ���Ȩ
		TextView name=(TextView)paramView.findViewById(R.id.name);
		TextView sex=(TextView)paramView.findViewById(R.id.sex);
		TextView age=(TextView)paramView.findViewById(R.id.age);
		People people=list.get(paramInt);
		name.setText(people.name);
		sex.setText(people.sex);
		age.setText(people.age);
		
		return paramView;
	}
	
    public void addList(People people){  
        list.add(people);  
    }
}
