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
    			 Shakespeare));//ʹ�þ�̬��������б�
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
        //��fragment֮��ͨ��Bundle��ֵ
        outState.putInt("curChoice", mCurCheckPosition);  
        outState.putInt("shownChoice", mShownCheckPosition);  
    }  
    
    
    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
    	 showDetails(position);  
    }

   /* ��ʾlistview item����*/
	private void showDetails(int index) {
		// TODO Auto-generated method stub
		mCurCheckPosition = index; 
		getListView().setItemChecked(index, true);
		if (mShownCheckPosition != mCurCheckPosition) {
			DetailsFragment df=DetailsFragment.newInstance(index);
			 FragmentTransaction ft = getFragmentManager()  
                     .beginTransaction();  
			 ft.replace(R.id.details, df);
			 //����fragment transaction�����л����ܷ����ṩ�л���Ч����
			 ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			 ft.commit();
			 mShownCheckPosition = index; 
		}
	}
}
