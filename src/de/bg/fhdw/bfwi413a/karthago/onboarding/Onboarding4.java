package de.bg.fhdw.bfwi413a.karthago.onboarding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import de.bg.fhdw.bfwi413a.karthago.R;
import de.bg.fhdw.bfwi413a.karthago.SessionManagement;

public class Onboarding4 extends Activity{
	
	protected AlphaAnimation fadeIn = new AlphaAnimation(0.0f , 1.0f ) ; 
	protected AlphaAnimation fadeOut = new AlphaAnimation( 1.0f , 0.0f ) ; 
	
	TextView txtView;
	ImageView imageview;
	SessionManagement session;
	RelativeLayout layout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.onboarding_4);
		session = new SessionManagement(this);
		txtView = (TextView) findViewById(R.id.textView1);
		imageview = (ImageView) findViewById(R.id.imageView1);
		layout = (RelativeLayout) findViewById(R.id.layout_great);
		
		txtView.append(session.getUserDetails() + "!");
		
		final Animation animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);
		final Animation animationFadeOut = AnimationUtils.loadAnimation(this, R.anim.fadeout);
		
		layout.setAnimation(animationFadeIn);
		animationFadeIn.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				layout.setAnimation(animationFadeOut);
				
			}
		});
		
		animationFadeOut.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				layout.setVisibility(View.INVISIBLE);
				// TODO Auto-generated method stub
				Intent i = new Intent(Onboarding4.this, Onboarding5.class);
				finish();
				startActivity(i);
				
			}
		});
		
		
	}
}
