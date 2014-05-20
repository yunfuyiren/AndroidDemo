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
	
	//������
	private EditText webUrlStr;
	private Button webUrlBut;
	private String url;
	private LinearLayout webUrlLayout;
	private GestureDetector mGestureDetector;
	
	//��ǰ���ť
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
		
		////////////////////////������/////////////////////////
		pb=(ProgressBar)v.findViewById(R.id.pb);
		pb.setMax(100);
		
	    this.webHolder = (WebView)v.findViewById(R.id.web_holder);
	    //����WebView���ԣ�
	    this.settings=this.webHolder.getSettings();	    
	    this.settings.setJavaScriptEnabled(true);   
	    //���ü��ؽ�����ҳ������Ӧ�ֻ���Ļ 
	    this.settings.setUseWideViewPort(true);
	    this.settings.setLoadWithOverviewMode(true);
	//  this.webHolder.getSettings().setDomStorageEnabled(true);
	    this.client=new OwnerWebView();
	    this.settings.setDefaultTextEncodingName("UTF-8");	   
	    //����Web��ͼ 
	    this.webHolder.setWebViewClient(this.client);	        
	    ///////////////����8��������///////////////
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
	    //������Ҫ��ʾ����ҳ 
	    this.webHolder.loadUrl("http://www.baidu.com");
	    
	    ///////////////////////////////������	/////////////////////////////////
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
						.setTitle("����")
						.setMessage("������Ч�ĵ�ַ")
						.create()
						.show();
					}
				}
			}
	    	
	    });
	    this.webUrlStr.addTextChangedListener(new WebUrlStrChangedLitener());
	    
	    ///////////////˫���˳��ڶ��ְ취�õ��ľ��/////////////
	    handler=new Handler();
	    webUrlLayout=(LinearLayout)v.findViewById(R.id.Nevigator);
	    
	    ////////////////////  ҳ����غ����ϻ�����������ʾ��ַ�������»������ײ������ص�ַ��///////////
	    //����ʶ�����
	    mGestureDetector=new GestureDetector(getActivity(),new  GestureListener());
	    webHolder.setOnTouchListener(new WebViewTouchListener());
	   
	    ///////////////////������ǰ���ť�������ɫ//////////
	    preButton=(Button)v.findViewById(R.id.PreButton);
	    nextButton=(Button)v.findViewById(R.id.NextButton);
	    return v;
	 }
	 
	 public boolean onCreateOptionsMenu(Menu menu) {
	      getActivity().getMenuInflater().inflate(R.menu.main, menu);
	      return true;
	  }
	 
	 ////////////Web��ͼ ģ��///////////////
	 //���ϣ��������Ӽ����ڵ�ǰ browser ����Ӧ���������¿� Android ��ϵͳ browser ����Ӧ�����ӣ����븲�� webview �� WebViewClient ���� Java
	  private class OwnerWebView extends WebViewClient{
		  public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)   
          {                 // Handle the error 
			  if(errorCode==WebViewClient.ERROR_HOST_LOOKUP){
		            //�Ҳ���ҳ�棬���ðٶ�����
		            url = "http://www.baidu.com/baidu?word=" + url;
		            webHolder.loadUrl(url);
		         }
              Toast.makeText(getActivity().getApplicationContext(), "��������ʧ�� ,���������硣",
                       Toast.LENGTH_SHORT).show();
          }                    
		  @Override
		  //����ҳ�г����Ӱ�ť����Ӧ
	      public boolean shouldOverrideUrlLoading(WebView view, String url) {
	         view.loadUrl(url);
	         return true;
	      }		  
		  /////////////////����9�� ���õ�����ӣ����õ�ַ����ַ///////////
		  @Override
		  public void onPageFinished(WebView view, String url) {
		     super.onPageFinished(view, url);
		     //���õ�ַ����ַ
		     webUrlStr.setText(url);
		     webUrlLayout.setVisibility(View.GONE);
		  //��ÿ��ҳ�������ɺ�鿴�Ƿ��п��Ի��ݵ���ʷ
		     changeStatueOfWebToolsButton();
		  }
	  }
	  
	  //////////////////////����2��������////////////////////////
	  //��������ĸı����������֤��ַ����Ч�ԣ��Դ��жϰ�ť�Ƿ�Ϊ�����롱״̬
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
		            //�ı䰴ť�ĺ���ʵ��
				 	webUrlBut.setText("����");
		     }else{
		    	 webUrlBut.setText("ȡ��");
		    }
		}		  
	  }
	  
	  ////////////////////////����4�� ���û��ˡ��˳�///////////// 
	 //ActivityĬ�ϵ�back������Ϊ������ǰActivity��webView�鿴�˺ܶ���ҳ��ϣ����back��������һ�������ҳ�棬���ʱ�����Ǿ���Ҫ����Activity��onKeyDown��������������δ���
	  public  boolean onKeyDown(int keyCode, KeyEvent event) {  
		  		
	         if (this.webHolder.canGoBack() && event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {  
	        	 this.webHolder.goBack();  
	             return true;  
	         }  
	         return true;
	  }
	  //�ڶ��ַ���,�����õ�Handler�ĵ��ö��߳�ʵ�ְ�
	  private boolean isExit=false;
	  private Handler handler;
	  public void onBackPressed(){
		  if(webHolder.canGoBack())
		  {
			  webHolder.goBack();
		  }else{
			  if(!isExit){
				  isExit=true;
				  Toast.makeText(getActivity().getApplicationContext(), "�ٰ�һ���˳�", Toast.LENGTH_SHORT).show();
				  handler.sendEmptyMessageDelayed(0,2000);
				  isExit=false;
			  }else
			  {
				  getActivity().finish();
				  System.exit(0);
			  }
			  
			  
		  }
	  }

	  ////////////����6�� ҳ����غ����ϻ�����������ʾ��ַ�������»������ײ������ص�ַ��////////////
	  /**
	  * GestureDetector.OnGestureListener�Զ���̳���
	  * ����������Ƶ����Ӧ����
	  * 1. ���ϻ���webView���������¼�����ʾ��ַ��
	  * 2. ���»���webView����ʱ�䣬���ص�ַ��
	  * */
	  //GestureDetector.OnGestureListener  �Զ�ʶ���ȡ����������
	  private class GestureListener implements GestureDetector.OnGestureListener{

		@Override
		public boolean onDown(MotionEvent e) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override   ///�������Ƶ�ģ��
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			// TODO Auto-generated method stub
			if(webHolder.getScrollY()==0)
			{
				//��������
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
	  //���Ƕ���webView��������˵�ģ�����ֻ��Ҫ���������
	  //��OnTouchListener�������ɣ�����������ȡ�����Ʋ������¼���
	  /**
	   * OnTouchListener�Զ���̳���
	   * ��������ƽ���GestureDetector����
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

	  ////////////////////����10:������ǰ���ť�������ɫ////////////
	  private void changeStatueOfWebToolsButton(){
		   if(webHolder.canGoBack()){
		      //���ÿ�ʹ��״̬
		      preButton.setEnabled(true);
		   }else{
		      //���ý�ֹ״̬
		      preButton.setEnabled(false);
		   }
		   if(webHolder.canGoForward()){
		      //���ÿ�ʹ��״̬
		      nextButton.setEnabled(true);
		   }else{
		      //���ý�ֹ״̬
		      nextButton.setEnabled(false);
		   }
	 }
}
