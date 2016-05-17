package com.mobilleon.smspro.activity;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.mobilleon.smspro.adapters.AboutViewPager;
import com.mobilleon.smspro.root.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;



public class AboutActivity extends SherlockFragmentActivity {
	private ViewPager _mViewPager;
	private AboutViewPager _adapter;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setUpView();
        setTab();
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(AboutActivity.this, SMSProActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            }
        return super.onOptionsItemSelected(item);
    }
    
    private void setUpView(){    	
   	 _mViewPager = (ViewPager) findViewById(R.id.viewPager);
     _adapter = new AboutViewPager(getApplicationContext(),getSupportFragmentManager());
     _mViewPager.setAdapter(_adapter);
	 _mViewPager.setCurrentItem(0);
    }
    private void setTab(){
			_mViewPager.setOnPageChangeListener(new OnPageChangeListener(){
			    		
						@Override
						public void onPageScrollStateChanged(int position) {}
						@Override
						public void onPageScrolled(int arg0, float arg1, int arg2) {}
						@Override
						public void onPageSelected(int position) {
							switch(position){
							case 0:
								findViewById(R.id.first_tab).setVisibility(View.VISIBLE);
								findViewById(R.id.second_tab).setVisibility(View.INVISIBLE);
								break;
								
							case 1:
								findViewById(R.id.first_tab).setVisibility(View.INVISIBLE);
								findViewById(R.id.second_tab).setVisibility(View.VISIBLE);
								break;
							}
					}
					
			});
    }
}