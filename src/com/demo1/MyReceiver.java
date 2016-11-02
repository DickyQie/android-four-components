package com.demo1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		 String name = intent.getExtras().getString("name");  
         Toast.makeText(context, "广播接收到:"+name, Toast.LENGTH_SHORT).show();  

	}

}
