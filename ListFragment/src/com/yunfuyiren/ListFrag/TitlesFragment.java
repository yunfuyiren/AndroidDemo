package com.yunfuyiren.ListFrag;

import com.yunfuyiren.listfragment.R;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class TitlesFragment extends ListFragment{
	private static final String[] Shakespeare ={
		"1","2","3","4"
	} ;
	int mCurCheckPosition = 0;  
    int mShownCheckPosition = -1;  
    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
    	 super.onActivityCreated(savedInstanceState);
    	 setListAdapter(new ArrayAdapter<String>(getActivity(),
    			 android.R.layout.simple_list_item_activated_1,
    			 Shakespeare));//使用静态数组填充列表
    	 if (savedInstanceState != null) {   
    		 mCurCheckPosition=savedInstanceState.getInt("curChoice", 0); 
    		 mShownCheckPosition = savedInstanceState.getInt("shownChoice", -1);  
    	 }
    	 getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    	 showDetails(mCurCheckPosition);
    }
    
    @Override  
    public void onSaveInstanceState(Bundle outState) {  
        super.onSaveInstanceState(outState);  
        //在fragment之间通过Bundle传值
        outState.putInt("curChoice", mCurCheckPosition);  
        outState.putInt("shownChoice", mShownCheckPosition);  
    }  
    
    
    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
    	 showDetails(position);  
    }

   /* 显示listview item详情*/
	private void showDetails(int index) {
		// TODO Auto-generated method stub
		mCurCheckPosition = index; 
		getListView().setItemChecked(index, true);
		if (mShownCheckPosition != mCurCheckPosition) {
			DetailsFragment df=DetailsFragment.newInstance(index);
			 FragmentTransaction ft = getFragmentManager()  
                     .beginTransaction();  
			 ft.replace(R.id.details, df);
			 //利用fragment transaction进行切换，很方便提供切换的效果。
			 ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			 ft.commit();
			 mShownCheckPosition = index; 
		}
	}
}
