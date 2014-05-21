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
    //适配器根据getCount()函数来确定要加载多少项  
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
     * 当列表里的每一项显示到界面时，都会调用这个方法一次，并返回一个view 所以方法里面尽量要简单，不要做没必要的动作(non-Javadoc) 
     * 我这里为了大家好理解，没有做优化 
     */  
    @Override  
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {  
        //得到列表样式的view对象  
        paramView=LayoutInflater.from(context).inflate(R.layout.list_items, null);  
        //通过view来得到Item中的每个控件的操作权  
        TextView name = (TextView)paramView.findViewById(R.id.name);  
        TextView sex = (TextView)paramView.findViewById(R.id.sex);  
        TextView age = (TextView)paramView.findViewById(R.id.age);  
        //获得list里面的第paramInt个对象，并把值赋给每个控件  
        People people = list.get(paramInt);  
        name.setText(people.name);  
        sex.setText(people.sex);  
        age.setText(people.age);  
        //把一项返回，加载这个View  
        return paramView;  
    }  
    public void addList(People people){  
        list.add(people);  
    }  
}
