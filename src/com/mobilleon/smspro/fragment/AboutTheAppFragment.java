
package com.mobilleon.smspro.fragment;

import com.actionbarsherlock.app.SherlockFragment;
import com.mobilleon.smspro.adapters.AboutAppAdapter;
import com.mobilleon.smspro.model.AboutAppAuthorItem;
import com.mobilleon.smspro.root.R;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class AboutTheAppFragment extends SherlockFragment {

    private AboutAppAdapter mAdapter;
    private List<AboutAppAuthorItem> mAboutItems;
    private ListView mAboutTheAppList;
    
    
	public static Fragment newInstance(Context context) {
		AboutTheAppFragment appFragment = new AboutTheAppFragment();	
		
		return appFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		ViewGroup root = (ViewGroup) inflater.inflate(R.layout.about_the_app_fragment, null);
		mAboutTheAppList = (ListView) root.findViewById(R.id.app_list);
		getAboutTheAppListItem();
		setAboutTheAppList();
		return root;
	}
	
    /** Setting adapter for list view */
    private void setAboutTheAppList() {

        if (!mAboutItems.isEmpty()) {
            mAdapter = new AboutAppAdapter(getSherlockActivity(), mAboutItems);
            mAboutTheAppList.setAdapter(mAdapter);
        } else {
            mAboutTheAppList.setAdapter(null);
        }
    }
    
    private void getAboutTheAppListItem(){
        mAboutItems = new ArrayList<AboutAppAuthorItem>();
        AboutAppAuthorItem mShareAppItem = new AboutAppAuthorItem();
        AboutAppAuthorItem mRateAppItem = new AboutAppAuthorItem();
        AboutAppAuthorItem mFeedbackAppItem = new AboutAppAuthorItem();
        
        mShareAppItem.setmImageIcon(getResources().getDrawable(R.drawable.ic_share_app));
        mShareAppItem.setmItemHeader("Share this app!");
        mShareAppItem.setmItemDescription("Tell your friends how great it is");
    
    mAboutItems.add(mShareAppItem);
    
    mRateAppItem.setmImageIcon(getResources().getDrawable(R.drawable.ic_rating_good));
    mRateAppItem.setmItemHeader("Rate this app on market!");
    mRateAppItem.setmItemDescription("Is it worth 5 stars");
    
    mAboutItems.add(mRateAppItem);
    
    mFeedbackAppItem.setmImageIcon(getResources().getDrawable(R.drawable.ic_feedback));
    mFeedbackAppItem.setmItemHeader("Send me your feedback!");
    mFeedbackAppItem.setmItemDescription("To make this app better");
    
    mAboutItems.add(mFeedbackAppItem);
    }

}
