package com.example.fftestcase;

import java.util.ArrayList;
import java.util.List;

import com.example.fftest.*;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter{
	private List<People> list = new ArrayList<People>();  
//  private People people = new People();  
    private Context context;  
      
    public ListAdapter(Context context){  
        this.context = context;  
    }  
    //����������getCount()������ȷ��Ҫ���ض�����  
    @Override  
    public int getCount() {  
        return list.size();  
    }  
  
    @Override  
    public Object getItem(int paramInt) {  
          
        return list.get(paramInt);  
    }  
  
    @Override  
    public long getItemId(int paramInt) {  
        return paramInt;  
    }  
    /* 
     * ���б����ÿһ����ʾ������ʱ����������������һ�Σ�������һ��view ���Է������澡��Ҫ�򵥣���Ҫ��û��Ҫ�Ķ���(non-Javadoc) 
     * ������Ϊ�˴�Һ���⣬û�����Ż� 
     */  
    @Override  
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {  
        //�õ��б���ʽ��view����  
        paramView=LayoutInflater.from(context).inflate(R.layout.list_items, null);  
        //ͨ��view���õ�Item�е�ÿ���ؼ��Ĳ���Ȩ  
        TextView name = (TextView)paramView.findViewById(R.id.name);  
        TextView sex = (TextView)paramView.findViewById(R.id.sex);  
        TextView age = (TextView)paramView.findViewById(R.id.age);  
        //���list����ĵ�paramInt�����󣬲���ֵ����ÿ���ؼ�  
        People people = list.get(paramInt);  
        name.setText(people.name);  
        sex.setText(people.sex);  
        age.setText(people.age);  
        //��һ��أ��������View  
        return paramView;  
    }  
    public void addList(People people){  
        list.add(people);  
    }  
}
