package com.example.myadapterdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;


public class MainActivity extends Activity {

	MyAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		System.out.println("*********Tab");  
		ListView listView=(ListView)findViewById(R.id.list);
		adapter=new MyAdapter(this);
		setPeople();
		listView.setAdapter(adapter);
	}
	
	public void setPeople(){  
        People people;  
        for(int i=1;i<5;i++){  
            people = new People();  
            people.name="ÕÅÈý";  
            people.sex = "ÄÐ";  
            people.age ="22";  
            adapter.addList(people);  
        }  
    }  
}
