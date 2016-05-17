
package com.mobilleon.smspro.fragment;

import com.actionbarsherlock.app.SherlockFragment;
import com.mobilleon.smspro.adapters.AboutAuthorAdapter;
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

public class AboutTheAuthorFragment extends SherlockFragment {

    private AboutAuthorAdapter mAdapter;
    private List<AboutAppAuthorItem> mAboutItems;
    private ListView mAboutTheAuthList;
    
    
    public static Fragment newInstance(Context context) {
        AboutTheAuthorFragment authorFragment = new AboutTheAuthorFragment();    
        
        return authorFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.about_the_author_fragment, null);
        mAboutTheAuthList = (ListView) root.findViewById(R.id.auth_list);
        getAboutTheAuthorListItem();
        setAboutTheAppList();
        return root;
    }
    
    /** Setting adapter for list view */
    private void setAboutTheAppList() {

        if (!mAboutItems.isEmpty()) {
            mAdapter = new AboutAuthorAdapter(getSherlockActivity(), mAboutItems);
            mAboutTheAuthList.setAdapter(mAdapter);
        } else {
            mAboutTheAuthList.setAdapter(null);
        }
    }
    
    private void getAboutTheAuthorListItem(){
        mAboutItems = new ArrayList<AboutAppAuthorItem>();
        AboutAppAuthorItem mFbAppItem = new AboutAppAuthorItem();
        AboutAppAuthorItem mTwitterAppItem = new AboutAppAuthorItem();
        AboutAppAuthorItem mGPlusAppItem = new AboutAppAuthorItem();
        
        mFbAppItem.setmImageIcon(getResources().getDrawable(R.drawable.ic_author_facebook));
        mFbAppItem.setmItemHeader("Find me on Facebook");
    
    mAboutItems.add(mFbAppItem);
    
    mTwitterAppItem.setmImageIcon(getResources().getDrawable(R.drawable.ic_author_twitter));
    mTwitterAppItem.setmItemHeader("Follow me on Twitter");
    
    mAboutItems.add(mTwitterAppItem);
    
    mGPlusAppItem.setmImageIcon(getResources().getDrawable(R.drawable.ic_author_googleplus));
    mGPlusAppItem.setmItemHeader("Circle me on Google+");
      
    mAboutItems.add(mGPlusAppItem);
    }

}
