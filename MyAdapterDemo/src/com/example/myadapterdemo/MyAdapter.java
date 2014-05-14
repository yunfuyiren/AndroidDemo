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
	private int resource;// 绑定的一个条目界面的id，此例中即为item.xml
	 private LayoutInflater inflater;// 布局填充器，它可以使用一个xml文件生成一个View对象，可以通过Context获取实例对象
	
	 public MyAdapter(Context context, List<People> persons, int resource) {
		  inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		  this.resource = resource;
		  this.list = persons;
	}
	 
	 public MyAdapter(Context context){  
	        this.context = context;  
	 }  
	 
	 @Override
	public int getCount() {// 得到要绑定的数据总数
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {// 给定索引值，得到索引值对应的对象
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {// 获取条目id
		// TODO Auto-generated method stub
		return arg0;
	}
	 // ListView有缓存功能，当显示第一页页面时会创建页面对象，显示第二页时重用第一页创建好了的对象
	 // 取得条目界面:position代表当前条目所要绑定的数据在集合中的索引值
	@Override
	public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
		// TODO Auto-generated method stub
		paramView=LayoutInflater.from(context)   // 创建视图容器并设置上下文  
				.inflate(R.layout.item, null);    // 获取list_item布局文件的视图
		//通过view来得到Item中每个控件的操作权
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
