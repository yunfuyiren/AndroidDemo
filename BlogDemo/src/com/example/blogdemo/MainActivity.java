package com.example.blogdemo;

import android.app.TabActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TabHost.TabSpec;

/**
 * @author wang
 *主Activity，放置5个Tab
 */
public class MainActivity extends TabActivity 
	implements OnCheckedChangeListener{
		/** Called when the activity is first created. */
		private TabHost tabHost;
		private Intent intentBlog;// Blog
		private Intent intentNews;// News
		private Intent intentSearch;// search
		private Intent intentRss;// RSS
		private Intent intentMore;// More
		
		private RadioButton rbBlog;
		private RadioButton rbNews;
		private RadioButton rbRss;
		private RadioButton rbSearch;
		private RadioButton rbMore;
		
		public String whichTab = "";// 当前选中Tab
		Resources res;// 资源
		@SuppressWarnings("deprecation")
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.tab_main);
			res = this.getResources();
			
			intentBlog = new Intent(this, BlogActivity.class);
			intentNews = new Intent(this, NewsActivity.class);
			intentRss = new Intent(this, MyRssActivity.class);
			intentSearch = new Intent(this, SearchActivity.class);
			intentMore = new Intent(this, MoreActivity.class);		
			InitialRadios();
			InitialTab();
			InitialSelectedTab();
		}
		
		/**
		 * 设置默认选中Tab
		 */
		private void InitialSelectedTab() {
			// TODO Auto-generated method stub
	/*		SharedPreferences是Android平台上一个轻量级的存储类，
			主要是保存一些常用的配置比如窗口状态，一般在Activity中重载窗口
			状态onSaveInstanceState保存一般使用SharedPreferences完成*/
			SharedPreferences settings = getSharedPreferences(
					res.getString(R.string.preferences_key), MODE_PRIVATE);
			whichTab = settings.getString(res.getString(R.string.preferences_current_tab), "blog");
			if (whichTab.equals("blog"))
				rbBlog.setChecked(true);
			else if (whichTab.equals("news"))
				rbNews.setChecked(true);
			else if (whichTab.equals("rss"))
				rbRss.setChecked(true);
			else if (whichTab.equals("search"))
				rbSearch.setChecked(true);
			else if (whichTab.equals("more"))
				rbMore.setChecked(true);
		}
		/**
		 * 初始化Tab
		 */
		@SuppressWarnings("deprecation")
		private void InitialTab() {
			// TODO Auto-generated method stub
			tabHost=this.getTabHost();
			tabHost.addTab(buildTabSpec("blog",R.string.main_home,R.drawable.icon,intentBlog));
			tabHost.addTab(buildTabSpec("news", R.string.main_news,
					R.drawable.icon, intentNews));
			tabHost.addTab(buildTabSpec("rss", R.string.main_rss, R.drawable.icon,
					intentRss));
			tabHost.addTab(buildTabSpec("search", R.string.main_search,
					R.drawable.icon, intentSearch));
			tabHost.addTab(buildTabSpec("more", R.string.main_more,
					R.drawable.icon, intentMore));
		}
		
		/**
		 * 公用初始化Tab
		 */
		private TabHost.TabSpec buildTabSpec(String tag, int resLabel, int resIcon,
				final Intent content) {
			// TODO Auto-generated method stub
			return tabHost
					.newTabSpec(tag)
					.setIndicator(getString(resLabel), 
							getResources().getDrawable(resIcon))
							.setContent(content);
		}
		/**
		 * 初始化单选按钮
		 */
		private void InitialRadios() {
			// TODO Auto-generated method stub
			rbBlog = (RadioButton) findViewById(R.id.TabBlog);
			rbBlog.setOnCheckedChangeListener(this);
			rbNews = (RadioButton) findViewById(R.id.TabNews);
			rbNews.setOnCheckedChangeListener(this);
			rbRss = (RadioButton) findViewById(R.id.TabRss);
			rbRss.setOnCheckedChangeListener(this);
			rbSearch = (RadioButton) findViewById(R.id.TabSearch);
			rbSearch.setOnCheckedChangeListener(this);
			rbMore = (RadioButton) findViewById(R.id.TabMore);
			rbMore.setOnCheckedChangeListener(this);
		}
		/**
		 * 设置当前Tab被选中后的Activity
		 * 
		 * @param buttonView
		 * @param isChecked
		 */
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			// TODO Auto-generated method stub
			if(!isChecked){
				return;
			}
			switch(buttonView.getId()){
				case R.id.TabBlog:
					whichTab="blog";
					tabHost.setCurrentTabByTag("blog");
					break;
				case R.id.TabNews:
					whichTab="news";
					tabHost.setCurrentTabByTag("news");
					break;
				case R.id.TabRss:
					whichTab="rss";
					tabHost.setCurrentTabByTag("rss");
					break;
				case R.id.TabSearch:
					whichTab = "search";
					tabHost.setCurrentTabByTag("search");
					break;
				case R.id.TabMore :
					whichTab = "more";
					tabHost.setCurrentTabByTag("more");
					break;
			}
		}
		
		@SuppressWarnings("deprecation")
		protected void onDestroy() {
			SharedPreferences settings = getSharedPreferences(
					res.getString(R.string.preferences_key), MODE_PRIVATE);
			SharedPreferences.Editor editor = settings.edit();
			editor.putString(res.getString(R.string.preferences_current_tab),
					whichTab);
			editor.commit();
			super.onDestroy();	
		}
}
