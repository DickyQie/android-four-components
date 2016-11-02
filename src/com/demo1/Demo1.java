package com.demo1;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class Demo1 extends Activity implements OnClickListener{
	
	public static final String NEW_LIFEFORM_DETECTED = "com.dxz.broadcasttest.NEW_LIFEFORM";  
	MyBoradCase receiver;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo1);
		 findViewById(R.id.button1).setOnClickListener(this);
		 findViewById(R.id.button2).setOnClickListener(this);
		//动态
		 IntentFilter counterActionFilter = new IntentFilter(NEW_LIFEFORM_DETECTED);  
	     receiver = new MyBoradCase();  
	     registerReceiver(receiver, counterActionFilter);  
	}
	
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			 Intent intent = new Intent();  
	         intent.setAction("com.xiazdong");  
	         intent.putExtra("name", "xiazdong");  
	         Demo1.this.sendBroadcast(intent);  
	        
			break;
		case R.id.button2:
			 Intent it = new Intent(NEW_LIFEFORM_DETECTED);  
             sendBroadcast(it);  
			break;
		default:
			break;
		}
		
		
	}
	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		unregisterReceiver(new MyBoradCase()); //取消监听
	}
	
	class MyBoradCase extends BroadcastReceiver
	{

		@Override
		public void onReceive(Context context, Intent intent) {
			
			Toast.makeText(context, "广播接收到:", Toast.LENGTH_SHORT).show(); 
		}
		
	}
	
	
	
	


}
