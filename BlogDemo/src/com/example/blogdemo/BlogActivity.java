package com.example.blogdemo;
import java.util.ArrayList;
import java.util.List;

import com.example.blogdemo.adapter.BlogListAdapter;
import com.example.blogdemo.entity.Blog;

import android.os.Bundle;
import android.widget.ListView;


/**
 * @author wang
 * �����б�
 * �õ���Blog�ࣨ����ʵ�壩��BlogListAdapter�������
 */
public class BlogActivity extends BaseMainActivity{
	List<Blog> listBlog=new ArrayList<Blog>();
	ListView listView;
	int pageIndex = 1;// ҳ��
	private BlogListAdapter adapter;// ����Դ
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.blog_layout);
	}
}
