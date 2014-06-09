package com.example.blogdemo;
import java.util.ArrayList;
import java.util.List;

import com.example.blogdemo.adapter.BlogListAdapter;
import com.example.blogdemo.entity.Blog;

import android.os.Bundle;
import android.widget.ListView;


/**
 * @author wang
 * 博客列表
 * 用到了Blog类（博客实体），BlogListAdapter类绑定数据
 */
public class BlogActivity extends BaseMainActivity{
	List<Blog> listBlog=new ArrayList<Blog>();
	ListView listView;
	int pageIndex = 1;// 页码
	private BlogListAdapter adapter;// 数据源
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.blog_layout);
	}
}
