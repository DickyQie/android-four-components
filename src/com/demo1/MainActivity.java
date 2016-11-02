package com.demo1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView l;
	String[] data={"隐式广播","内存卡数据保存"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    
    
    
    private void initView() {
		l=(ListView)findViewById(R.id.list1);
		ArrayAdapter<String>   adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, data);
		l.setAdapter(adapter);
		l.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				showSwitch(position);
				
			}
		});
		
		
	}
    
    Intent intent;
    private void showSwitch(int i) {
		switch (i) {
		case 0://Demo Demo1
			intent=new Intent(MainActivity.this,Demo1.class);
			
			break;
		case 1:
			intent=new Intent(MainActivity.this,Demo1.class);
			break;
		case 2:
			intent=new Intent(MainActivity.this,Demo1.class);
			break;
		case 3:
			intent=new Intent(MainActivity.this,Demo1.class);
			break;
		case 4:
			intent=new Intent(MainActivity.this,Demo1.class);
			break;
		default:
			break;
		}
		startActivity(intent);
	}
}
