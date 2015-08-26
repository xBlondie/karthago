package de.bg.fhdw.bfwi413a.karthago.onboarding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import de.bg.fhdw.bfwi413a.karthago.R;

public class StartOnboarding extends Activity{
	
	// DECLARE NECESSARY VARIABLES
	TextView txtView;
	ImageView imageview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//SET LAYOUT
		setContentView(R.layout.onboarding_start);
		
		// INITIALIZE GUI-ELEMENTS
		txtView = (TextView) findViewById(R.id.hey);
		imageview = (ImageView) findViewById(R.id.imageView1);
		
		//INITIALIZE ANIMATIONS
		final Animation animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);
		final Animation animationFadeOut = AnimationUtils.loadAnimation(this, R.anim.fadeout);
		
		//SET ANIMATION
		txtView.setAnimation(animationFadeIn);
		
		//SET FADE-IN ANIMATIONLISTENER
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
				//DIRECTLY START THE NEW ANIMATION
				txtView.setAnimation(animationFadeOut);
				
			}
		});
		
		//SET FADE-OUT ANIMATIONLISTENER
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
				//SET ELEMENTS INVISIBLE (LOOKS BETTER WHEN SWITCHING ACTIVITY)
				txtView.setVisibility(View.INVISIBLE);
				imageview.setVisibility(View.INVISIBLE);


				//CREATE NEW ACTIVITY WITH NEXT INSTRUCTION				
				Intent i = new Intent(StartOnboarding.this, Onboarding2.class);
				finish();
				startActivity(i);
				
			}
		});
	}
}
