package com.example.addbuttonddemo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnClickListener{
	private Button add_btn,remove_btn;
	private LinearLayout linearLayout;
	private int index=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViews();
		register();
	}
	private void register() { //设置接听方法
        add_btn.setOnClickListener(this);
        remove_btn.setOnClickListener(this);
    }

    private void findViews() {
        add_btn = (Button) findViewById(R.id.add);
        remove_btn = (Button) findViewById(R.id.remove);
        linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
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

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	@Override           
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.add:
			linearLayout.addView(createView(),1);
			break;
		case R.id.remove:
			removeView();
			break;
			default:break;
		}
	}
	
	protected View createView(){
		Button btn=new Button(this);
		btn.setId(index++);
		btn.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
		btn.setText("按钮"+index);
		return btn;
	}
	
	private void removeView(){
		//获取linearlayout子view的个数
		int count=linearLayout.getChildCount();
		Log.d("haha",String.valueOf(count));
        //研究整个LAYOUT布局，第0位的是含add和remove两个button的layout
        //第count-1个是那个文字被置中的textview
        //因此，在remove的时候，只能操作的是0<location<count-1这个范围的
        //在执行每次remove时，我们从count-2的位置即textview上面的那个控件开始删除~
        if (count - 2 > 0) {
            //count-2>0用来判断当前linearlayout子view数多于2个，即还有我们点add增加的button
            linearLayout.removeViewAt(count - 2);
        }
	}
}
