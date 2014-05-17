package com.example.webadddemo;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

public class PageFragment extends Fragment {
	private WebView webHolder;
	private WebSettings settings;
	private WebViewClient client;
	private ProgressBar pb;
	
	//导航栏
	private EditText webUrlStr;
	private Button webUrlBut;
	private String url;
	private LinearLayout webUrlLayout;
	private GestureDetector mGestureDetector;
	
	//向前向后按钮
	private Button preButton;
	private Button nextButton;
	@Override  
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v=LayoutInflater.from(getActivity()).
		inflate(R.layout.web_page, null);
		
		////////////////////////进度条/////////////////////////
		pb=(ProgressBar)v.findViewById(R.id.pb);
		pb.setMax(100);
		
	    this.webHolder = (WebView)v.findViewById(R.id.web_holder);
	    //设置WebView属性，
	    this.settings=this.webHolder.getSettings();	    
	    this.settings.setJavaScriptEnabled(true);   
	    //设置加载进来的页面自适应手机屏幕 
	    this.settings.setUseWideViewPort(true);
	    this.settings.setLoadWithOverviewMode(true);
	//  this.webHolder.getSettings().setDomStorageEnabled(true);
	    this.client=new OwnerWebView();
	    this.settings.setDefaultTextEncodingName("UTF-8");	   
	    //设置Web视图 
	    this.webHolder.setWebViewClient(this.client);	        
	    ///////////////功能8：进度条///////////////
	    this.webHolder.setWebChromeClient(new WebChromeClient(){
			  @Override  
			    public void onProgressChanged(WebView view, int newProgress) {  
				  	super.onProgressChanged(view, newProgress);  
			        if(newProgress==100){  
			            pb.setVisibility(View.GONE);  
			        }else{
			        	pb.setVisibility(View.VISIBLE);
			        	pb.setProgress(newProgress);
			        }   
			    }  
	    });	 
	    //加载需要显示的网页 
	    this.webHolder.loadUrl("http://www.baidu.com");
	    
	    ///////////////////////////////导航栏	/////////////////////////////////
	    this.webUrlStr=(EditText)v.findViewById(R.id.web_url_input);
	    this.webUrlBut=(Button)v.findViewById(R.id.web_url_goto);
	    this.webUrlBut.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(v.getId()==R.id.web_url_goto){
					String url=webUrlStr.getText().toString();
					if(URLUtil.isNetworkUrl(url)&&URLUtil.isValidUrl(url)){
						webHolder.loadUrl(url);
					}else{
						new AlertDialog.Builder(getActivity())
						.setTitle("警告")
						.setMessage("不是有效的地址")
						.create()
						.show();
					}
				}
			}
	    	
	    });
	    this.webUrlStr.addTextChangedListener(new WebUrlStrChangedLitener());
	    
	    ///////////////双击退出第二种办法用到的句柄/////////////
	    handler=new Handler();
	    webUrlLayout=(LinearLayout)v.findViewById(R.id.Nevigator);
	    
	    ////////////////////  页面加载后向上滑动到顶部显示地址栏，向下滑动到底部，隐藏地址栏///////////
	    //手势识别对象
	    mGestureDetector=new GestureDetector(getActivity(),new  GestureListener());
	    webHolder.setOnTouchListener(new WebViewTouchListener());
	   
	    ///////////////////设置向前向后按钮，无则灰色//////////
	    preButton=(Button)v.findViewById(R.id.PreButton);
	    nextButton=(Button)v.findViewById(R.id.NextButton);
	    return v;
	 }
	 
	 public boolean onCreateOptionsMenu(Menu menu) {
	      getActivity().getMenuInflater().inflate(R.menu.main, menu);
	      return true;
	  }
	 
	 ////////////Web视图 模块///////////////
	 //如果希望点击链接继续在当前 browser 中响应，而不是新开 Android 的系统 browser 中响应该链接，必须覆盖 webview 的 WebViewClient 对象： Java
	  private class OwnerWebView extends WebViewClient{
		  public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)   
          {                 // Handle the error 
			  if(errorCode==WebViewClient.ERROR_HOST_LOOKUP){
		            //找不到页面，调用百度搜搜
		            url = "http://www.baidu.com/baidu?word=" + url;
		            webHolder.loadUrl(url);
		         }
              Toast.makeText(getActivity().getApplicationContext(), "网络连接失败 ,请连接网络。",
                       Toast.LENGTH_SHORT).show();
          }                    
		  @Override
		  //对网页中超链接按钮的响应
	      public boolean shouldOverrideUrlLoading(WebView view, String url) {
	         view.loadUrl(url);
	         return true;
	      }		  
		  /////////////////功能9： 设置点击链接，设置地址栏地址///////////
		  @Override
		  public void onPageFinished(WebView view, String url) {
		     super.onPageFinished(view, url);
		     //设置地址栏地址
		     webUrlStr.setText(url);
		     webUrlLayout.setVisibility(View.GONE);
		  //在每次页面加载完成后查看是否有可以回溯的历史
		     changeStatueOfWebToolsButton();
		  }
	  }
	  
	  //////////////////////功能2：导航栏////////////////////////
	  //监听输入的改变情况，来验证地址的有效性，以此判断按钮是否为“进入”状态
	  private class WebUrlStrChangedLitener implements TextWatcher{

		@Override
		public void afterTextChanged(Editable arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub
			url=arg0.toString();
			if(!(url.startsWith("http://")||url.startsWith("https://"))){
				url="http://"+url;
			}
			 Log.d("hahaha","onchangeText:"+url);
			 if(URLUtil.isNetworkUrl(url)&&URLUtil.isValidUrl(url)){
		            //改变按钮的函数实现
				 	webUrlBut.setText("进入");
		     }else{
		    	 webUrlBut.setText("取消");
		    }
		}		  
	  }
	  
	  ////////////////////////功能4： 设置回退。退出///////////// 
	 //Activity默认的back键处理为结束当前Activity，webView查看了很多网页后，希望按back键返回上一次浏览的页面，这个时候我们就需要覆盖Activity的onKeyDown函数，告诉他如何处理
	  public  boolean onKeyDown(int keyCode, KeyEvent event) {  
		  		
	         if (this.webHolder.canGoBack() && event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {  
	        	 this.webHolder.goBack();  
	             return true;  
	         }  
	         return true;
	  }
	  //第二种方法,不过用到Handler的得用多线程实现啊
	  private boolean isExit=false;
	  private Handler handler;
	  public void onBackPressed(){
		  if(webHolder.canGoBack())
		  {
			  webHolder.goBack();
		  }else{
			  if(!isExit){
				  isExit=true;
				  Toast.makeText(getActivity().getApplicationContext(), "再按一次退出", Toast.LENGTH_SHORT).show();
				  handler.sendEmptyMessageDelayed(0,2000);
				  isExit=false;
			  }else
			  {
				  getActivity().finish();
				  System.exit(0);
			  }
			  
			  
		  }
	  }

	  ////////////功能6： 页面加载后向上滑动到顶部显示地址栏，向下滑动到底部，隐藏地址栏////////////
	  /**
	  * GestureDetector.OnGestureListener自定义继承类
	  * 解决各种手势的相对应策略
	  * 1. 向上滑动webView到顶触发事件，显示地址栏
	  * 2. 向下滑动webView触发时间，隐藏地址栏
	  * */
	  //GestureDetector.OnGestureListener  自动识别获取到的手势类
	  private class GestureListener implements GestureDetector.OnGestureListener{

		@Override
		public boolean onDown(MotionEvent e) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override   ///滑动手势的模块
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			// TODO Auto-generated method stub
			if(webHolder.getScrollY()==0)
			{
				//滑到顶部
				webUrlLayout.setVisibility(View.VISIBLE);
			}
			if(webHolder.getScrollY()>0)
			{
				webUrlLayout.setVisibility(View.GONE);
			}
			return false;
		}

		@Override
		public void onLongPress(MotionEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void onShowPress(MotionEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean onSingleTapUp(MotionEvent e) {
			// TODO Auto-generated method stub
			return false;
		}
		  
	  }	  
	  //势是对于webView这个组件来说的，所以只需要这个组件添加
	  //了OnTouchListener方法即可，这个方法会获取到手势产生的事件：
	  /**
	   * OnTouchListener自定义继承类
	   * 解决将手势交给GestureDetector类解决
	   * */
	  private class WebViewTouchListener implements OnTouchListener{

		@Override
		public boolean onTouch(View arg0, MotionEvent arg1) {
			// TODO Auto-generated method stub
			if(arg0.getId()==R.id.web_holder){
				return mGestureDetector.onTouchEvent(arg1);
			}
			return false;
		}
		  
	  }

	  ////////////////////功能10:设置向前向后按钮，无则灰色////////////
	  private void changeStatueOfWebToolsButton(){
		   if(webHolder.canGoBack()){
		      //设置可使用状态
		      preButton.setEnabled(true);
		   }else{
		      //设置禁止状态
		      preButton.setEnabled(false);
		   }
		   if(webHolder.canGoForward()){
		      //设置可使用状态
		      nextButton.setEnabled(true);
		   }else{
		      //设置禁止状态
		      nextButton.setEnabled(false);
		   }
	 }
}
