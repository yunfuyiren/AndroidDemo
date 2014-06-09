package com.example.blogdemo.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;




import com.example.blogdemo.cache.AsyncImageLoader;
import com.example.blogdemo.entity.Blog;

public class BlogListAdapter extends BaseAdapter{
	private ListView listView;
	private AsyncImageLoader asyncImageLoader;	//动态加载图片类
	private List<Blog> list;
	private LayoutInflater mInflater;   //用来获得布局文件对象的，
	private Context currentContext;
	public BlogListAdapter(Context context, List<Blog> list, ListView listView) {
		currentContext = context;
		this.listView = listView;
		asyncImageLoader = new AsyncImageLoader(context);
		this.list = list;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
