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
import android.widget.TextView;
import de.bg.fhdw.bfwi413a.karthago.R;

public class EndOnboarding extends Activity{
	protected AlphaAnimation fadeIn = new AlphaAnimation(0.0f , 1.0f ) ; 
	protected AlphaAnimation fadeOut = new AlphaAnimation( 1.0f , 0.0f ) ; 
	TextView txtView;
	ImageView imageview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.onboarding_end);
		
		txtView = (TextView) findViewById(R.id.hey);
		imageview = (ImageView) findViewById(R.id.imageView1);
		
		final Animation animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);
		final Animation animationFadeOut = AnimationUtils.loadAnimation(this, R.anim.fadeout);
		
		txtView.setAnimation(animationFadeIn);
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
				txtView.setAnimation(animationFadeOut);
				
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
				txtView.setVisibility(View.INVISIBLE);
				imageview.setVisibility(View.INVISIBLE);
				// TODO Auto-generated method stub
				Intent i = new Intent(EndOnboarding.this, de.bg.fhdw.bfwi413a.karthago.activities.menu.Init.class);
				finish();
				startActivity(i);
				
			}
		});
	}
}
