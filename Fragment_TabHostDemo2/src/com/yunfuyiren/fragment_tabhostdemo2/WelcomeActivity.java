package com.yunfuyiren.fragment_tabhostdemo2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class WelcomeActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcomelogo);
		ImageView logo=(ImageView)findViewById(R.id.logo2);
		Animation logo_animation=AnimationUtils.loadAnimation(WelcomeActivity.this,
				R.anim.push_left_in);
		logo.setAnimation(logo_animation);
		logo_animation.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(WelcomeActivity.this,MainActivity.class);
				startActivity(it);
				WelcomeActivity.this.finish();
			}

			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}
