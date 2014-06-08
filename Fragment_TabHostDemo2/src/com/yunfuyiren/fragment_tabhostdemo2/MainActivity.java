package com.yunfuyiren.fragment_tabhostdemo2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
	TabHost tabHost;
	TabWidget tabWidget;
	LinearLayout bottom_layout;
	int CURRENT_TAB = 0;        //设置常量
	Home_Fragment homeFragment;				//通知项 tab_fragment
	CollectionSegment_Fragment collectFragment;		//收藏板块 tab_fragment
	Top10_Fragment top10Fragment;			//十大新闻板块 tab_fragment
	HotSegment_Fragment	hotFragment;		//热门板块 	tab_fragment
	Me_Fragment meFragment;					//个人中心板块	 me_fragment
	RelativeLayout tabIndicator1,tabIndicator2,tabIndicator3,tabIndicator4,tabIndicator5;
	
	FragmentTransaction ft;
	@SuppressLint("CommitTransaction")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findTabView();
		tabHost.setup();
		/** 监听*/
		TabHost.OnTabChangeListener tabChangeListener = new TabHost.OnTabChangeListener() {
			
			@Override
			public void onTabChanged(String tabId) {
				// TODO Auto-generated method stub
				/**管理*/
				FragmentManager fm =getSupportFragmentManager();
				homeFragment=(Home_Fragment)fm.findFragmentByTag("home");
				collectFragment=(CollectionSegment_Fragment)fm.findFragmentByTag("collection");
				top10Fragment =(Top10_Fragment) fm.findFragmentByTag("top10");
				hotFragment=(HotSegment_Fragment) fm.findFragmentByTag("hot");
				meFragment = (Me_Fragment) fm.findFragmentByTag("me");
				ft=fm.beginTransaction();
				
				/** 如果存在Detaches掉 */
				 if(homeFragment!=null)
					 ft.detach(homeFragment);
				 /** 如果存在Detaches掉 */
				 if(collectFragment!=null)
					 ft.detach(collectFragment);
				 if(top10Fragment!=null)
					 ft.detach(top10Fragment);
				 if(hotFragment!=null)
					 ft.detach(hotFragment);
				 if(meFragment!=null)
					 ft.detach(meFragment);
				 
				 /** 如果当前选项卡是home */
                 if(tabId.equalsIgnoreCase("home")){
                         isTabHome();
                         CURRENT_TAB = 1;
                         
                 /** 如果当前选项卡是collection */
                 }else if(tabId.equalsIgnoreCase("collection")){        
                         isTabCollection();
                         CURRENT_TAB = 2;
                         
                 /** 如果当前选项卡是message */
                 }else if(tabId.equalsIgnoreCase("top10")){        
                         isTabTop10();
                         CURRENT_TAB = 3;
                 /** 如果当前选项卡是hot */        
                 }else if(tabId.equalsIgnoreCase("hot")){  
                	 	isTabHot();
                	 	 CURRENT_TAB = 4;
                 /** 如果当前选项卡是me */
                 }else if(tabId.equalsIgnoreCase("me")){        
                         isTabMe();
                         CURRENT_TAB = 5;
                 }else{
                	 switch (CURRENT_TAB) {
                     case 1:
                             isTabHome();
                             break;
                     case 2:
                             isTabCollection();
                             break;
                     case 3:
                             isTabTop10();
                             break;
                     case 4:
                             isTabHot();
                             break;
                     case 5:
	                    	 isTabMe();
	                         break;
                     default:
                             isTabHome();
                             break;
                     }                
                 }
                 ft.commit();
			}
		};
		//设置初始选项卡  
		tabHost.setCurrentTab(0);
		tabHost.setOnTabChangedListener(tabChangeListener);
		initTab();
	}
	private void initTab() {
		// TODO Auto-generated method stub
		TabHost.TabSpec tSpecHome=tabHost.newTabSpec("home");
		//　每个选项卡都有一个选项卡指示符,内容和tag标签用于跟踪。这种生成器可以帮助从这些选项中做出选择
		 tSpecHome.setIndicator(tabIndicator1);
		 tSpecHome.setContent(new DummyTabContent(getBaseContext()));
		 tabHost.addTab(tSpecHome);
		 
		 TabHost.TabSpec tSpecWall=tabHost.newTabSpec("collection");
		 tSpecWall.setIndicator(tabIndicator2);
		 tSpecWall.setContent(new DummyTabContent(getBaseContext()));
		 tabHost.addTab(tSpecWall);
		 
		 TabHost.TabSpec tSpecCamera = tabHost.newTabSpec("top10");
	        tSpecCamera.setIndicator(tabIndicator3);        
	        tSpecCamera.setContent(new DummyTabContent(getBaseContext()));
	        tabHost.addTab(tSpecCamera);
//	        tabIndicator3.setOnClickListener(new OnClickListener(){
//				@Override
//				public void onClick(View v) {
//					// TODO Auto-generated method stub
//					Dialog choose = new Dialog(MainActivity.this,R.style.draw_dialog);
//					 choose.setContentView(R.layout.camera_dialog);
//					// 设置背景模糊参数
//					 WindowManager.LayoutParams winlp=choose.getWindow()
//							 .getAttributes();
//					 winlp.alpha=0.9f;
//					 choose.getWindow();
//					 choose.show(); // 显示弹出框
//				}	        	
//	        });
	        
	        TabHost.TabSpec tSpecMessage = tabHost.newTabSpec("hot");
	        tSpecMessage.setIndicator(tabIndicator4);      
	        tSpecMessage.setContent(new DummyTabContent(getBaseContext()));
	        tabHost.addTab(tSpecMessage);
	        
	        TabHost.TabSpec tSpecMe = tabHost.newTabSpec("me");
	        tSpecMe.setIndicator(tabIndicator5);        
	        tSpecMe.setContent(new DummyTabContent(getBaseContext()));
	        tabHost.addTab(tSpecMe);
	}
	//判断当前
    public void isTabHome(){
            
            if(homeFragment==null){                
                        ft.add(R.id.realtabcontent,new Home_Fragment(), "home");                                                
                }else{
                        ft.attach(homeFragment);                                                
                }
    }
    
    public void isTabCollection(){
            
            if(collectFragment==null){
                        ft.add(R.id.realtabcontent,new CollectionSegment_Fragment(), "collection");                                                
                }else{
                        ft.attach(collectFragment);                                                
                }
    }
    
    public void isTabTop10(){
            
            if(top10Fragment==null){
                        ft.add(R.id.realtabcontent,new Top10_Fragment(), "top10");                                                
                }else{
                        ft.attach(top10Fragment);                                                
                }
    }
    
    public void isTabHot(){
    	if(hotFragment==null){
    		ft.add(R.id.realtabcontent, new HotSegment_Fragment(), "hot");
    	}else{
    		ft.attach(hotFragment);
    	}
    }
    public void isTabMe(){
            
            if(meFragment==null){
                        ft.add(R.id.realtabcontent,new Me_Fragment(), "me");                                                
                }else{
                        ft.attach(meFragment);        
                }
    }
    /**
         * 找到Tabhost布局
         */
	private void findTabView() {
		// TODO Auto-generated method stub
		tabHost=(TabHost)findViewById(android.R.id.tabhost);
		tabWidget = (TabWidget) findViewById(android.R.id.tabs);
		LinearLayout layout=(LinearLayout)tabHost.getChildAt(0);
		TabWidget tw=(TabWidget)layout.getChildAt(1);
		
		 tabIndicator1 = (RelativeLayout) LayoutInflater.from(this)
				 .inflate(R.layout.tab_indicator, tw,false);
		 TextView tvTab1 = (TextView)tabIndicator1.getChildAt(1);
		 ImageView ivTab1 = (ImageView)tabIndicator1.getChildAt(0);
		 ivTab1.setBackgroundResource(R.drawable.selector_mood_home);
		 tvTab1.setText(R.string.buttom_home);
        
		 tabIndicator2 = (RelativeLayout) LayoutInflater.from(this)
                 .inflate(R.layout.tab_indicator, tw, false);
		 TextView tvTab2 = (TextView)tabIndicator2.getChildAt(1);
		 ImageView ivTab2 = (ImageView)tabIndicator2.getChildAt(0);
		 ivTab2.setBackgroundResource(R.drawable.selector_mood_wall);
		 tvTab2.setText(R.string.buttom_collect);
		 
		 tabIndicator3 = (RelativeLayout) LayoutInflater.from(this)
		                 .inflate(R.layout.tab_indicator, tw, false);
		 TextView tvTab3 = (TextView)tabIndicator3.getChildAt(1);
		 ImageView ivTab3 = (ImageView)tabIndicator3.getChildAt(0);
		 ivTab3.setBackgroundResource(R.drawable.selector_mood_photograph);
		 tvTab3.setText(R.string.buttom_top10);
		  
		 tabIndicator4 = (RelativeLayout) LayoutInflater.from(this)
		                 .inflate(R.layout.tab_indicator, tw, false);
		 TextView tvTab4 = (TextView)tabIndicator4.getChildAt(1);
		 ImageView ivTab4 = (ImageView)tabIndicator4.getChildAt(0);
		 ivTab4.setBackgroundResource(R.drawable.selector_mood_message);
		 tvTab4.setText(R.string.buttom_hot);
		 
		 tabIndicator5 = (RelativeLayout) LayoutInflater.from(this)
		                 .inflate(R.layout.tab_indicator, tw, false);
		 TextView tvTab5 = (TextView)tabIndicator5.getChildAt(1);
		 ImageView ivTab5 = (ImageView)tabIndicator5.getChildAt(0);
		 ivTab5.setBackgroundResource(R.drawable.selector_mood_my_wall);
		 tvTab5.setText(R.string.buttom_me);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
