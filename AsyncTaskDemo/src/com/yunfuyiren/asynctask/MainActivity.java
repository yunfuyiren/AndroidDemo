package com.yunfuyiren.asynctask;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		private final String TAG = "ASYNC_TASK";  
	      
	    private Button execute;  
	    private Button cancel;  
	    private ProgressBar progressBar;  
	    private TextView textView;  	      
	    private MyTask mTask; 
		public PlaceholderFragment() {
		}
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);	
		}
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			 execute = (Button)rootView.findViewById(R.id.execute);  
		     execute.setOnClickListener(new OnClickListener(){
		            @Override  
		            public void onClick(View v) {  
		                //ע��ÿ����newһ��ʵ��,�½�������ֻ��ִ��һ��,���������쳣  
		                mTask = new MyTask();  
		                mTask.execute("http://www.baidu.com");  
		                  
		                execute.setEnabled(false);  
		                cancel.setEnabled(true);  
		            }  
		      });  
		        
		        cancel = (Button) rootView.findViewById(R.id.cancel);  
		        cancel.setOnClickListener(new OnClickListener() {  
		            @Override  
		            public void onClick(View v) {  
		                //ȡ��һ������ִ�е�����,onCancelled�������ᱻ����  
		                mTask.cancel(true);  
		            }  
		        });  
		        progressBar = (ProgressBar)rootView.findViewById(R.id.progress_bar);  
		        textView = (TextView)rootView.findViewById(R.id.text_view);
			return rootView;
		}
		
		public class MyTask extends AsyncTask<String,Integer,String>{
			//onPreExecute����������ִ�к�̨����ǰ��һЩUI����  
		    @Override  
		    protected void onPreExecute() {  
		        Log.i(TAG, "onPreExecute() called"); 
		          
		        textView.setText("loading...");  
		    }  
		    
			@Override
			protected String doInBackground(String... params) {
				// TODO Auto-generated method stub
				Log.i(TAG, "doInBackground(Params... params) called");  
				try {  
					 HttpClient client = new DefaultHttpClient();  
		             HttpGet get = new HttpGet(params[0]);  
		             HttpResponse response = client.execute(get);  
		             if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {  
		                HttpEntity entity = response.getEntity();  
		                InputStream is = entity.getContent();  
		                long total = entity.getContentLength();  
		                ByteArrayOutputStream baos = new ByteArrayOutputStream();  
	                    byte[] buf = new byte[1024];  
	                    int count = 0;  
	                    int length = -1;  
	                    while ((length = is.read(buf)) != -1) {  
	                        baos.write(buf, 0, length);  
	                        count += length;  
	                        //����publishProgress��������,���onProgressUpdate��������ִ��  
	                        publishProgress((int) ((count / (float) total) * 100));  
	                        //Ϊ����ʾ����,����500����  
	                        Thread.sleep(500);  
	                    }  
	                    return new String(baos.toByteArray(), "gb2312");  
	                }  
	            } catch (Exception e) {  
	                Log.e(TAG, e.getMessage());  
	            }  
				return null;
			}
			
			//onProgressUpdate�������ڸ��½�����Ϣ  
	        @Override  
	        protected void onProgressUpdate(Integer... progresses) {  
	            Log.i(TAG, "onProgressUpdate(Progress... progresses) called");  
	            progressBar.setProgress(progresses[0]);  
	            textView.setText("loading..." + progresses[0] + "%");  
	        }
	        
	        //onPostExecute����������ִ�����̨��������UI,��ʾ���  
	        @Override  
	        protected void onPostExecute(String result) {  
	            Log.i(TAG, "onPostExecute(Result result) called");  
	            textView.setText(result);  
	              
	            execute.setEnabled(true);  
	            cancel.setEnabled(false);  
	        } 
	        
	        //onCancelled����������ȡ��ִ���е�����ʱ����UI  
	        @Override  
	        protected void onCancelled() {  
	            Log.i(TAG, "onCancelled() called");  
	            textView.setText("cancelled");  
	            progressBar.setProgress(0);  
	              
	            execute.setEnabled(true);  
	            cancel.setEnabled(false);  
	        }  
		}
	}

}
