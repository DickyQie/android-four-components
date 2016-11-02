# 广播 (Broadcast)
	<div class="edit-body">
		<div class="container">
			<!-- 编辑器图标部分 -->
			<div class="edit-toolbar clearfix">
				<div class="container">
					<div class="layout-right editor-toggle">
						<div class="select-box select-editor">
							<input type="hidden" name="content_type" id="editor_value" class="select-input" value="4">
																					<span class="select-show">可视化编辑器</span>
																				</div>
					</div>
				</div>
			</div>
			<div class="edit-box">
				<textarea name="content" class="editor-content"  id="ckeditor" > &lt;p&gt;广播 :在Android中，Broadcast是一种广泛运用的在应用程序之间传输信息的机制。我们拿广播电台来做个比方。我们平常使用收音机收音是这样的：许许多多不同的广播电台通过特定的频率来发送他们的内容，而我们用户只需要将频率调成和广播电台的一样就可以收听他们的内容了。Android中的广播机制就和这个差不多的道理,Android广播分为两个方面：广播发送者和广播接收者，通常情况下，BroadcastReceiver指的就是广播接收者（广播接收器）。&lt;/p&gt; 
&lt;p&gt;从实现原理看上，Android中的广播使用了观察者模式，基于消息的发布/订阅事件模型。因此，从实现的角度来看，Android中的广播将广播的发送者和接受者极大程度上解耦，使得系统能够方便集成，更易扩展。具体实现流程要点粗略概括如下：&lt;/p&gt; 
&lt;p&gt;1.广播接收者BroadcastReceiver通过Binder机制向AMS(Activity Manager Service)进行注册；&lt;/p&gt; 
&lt;p&gt;2.广播发送者通过binder机制向AMS发送广播；&lt;/p&gt; 
&lt;p&gt;3.AMS查找符合相应条件（IntentFilter/Permission等）的BroadcastReceiver，将广播发送到BroadcastReceiver（一般情况下是Activity）相应的消息循环队列中；&lt;/p&gt; 
&lt;p&gt;4.消息循环执行拿到此广播，回调BroadcastReceiver中的onReceive()方法。&lt;/p&gt; 
&lt;p&gt;现在我们就来实现一个简单的广播程序。Android提供了两种注册广播接受者的形式，分别是在程序中动态注册和在xml中指定。他们之间的区别就是作用的范围不同，程序动态注册的接收者只在程序运行过程中有效，而在xml注册的接收者不管你的程序有没有启动有会起作用。首先介绍在程序中动态注册的方式。&lt;/p&gt; 
&lt;h3&gt;动态注册方式：&lt;/h3&gt; 
&lt;pre&gt;public class MainActivity extends Activity {
    public static final String BROADCAST_ACTION = "com.example.corn";
    private BroadcastReceiver mBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBroadcastReceiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BROADCAST_ACTION);
        registerReceiver(mBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mBroadcastReceiver);
    }

    class MyBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if(null!=intent)
                Toast.makeText(context, "广播接收到:", Toast.LENGTH_SHORT).show();
        }
    }&lt;/pre&gt; 
&lt;h1&gt;&lt;strong&gt;配置文件方式:&lt;/strong&gt;&lt;/h1&gt; 
&lt;pre&gt;public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent();
        intent.setAction("com.li");
        intent.putExtra("name", "li");
        MainActivity .this.sendBroadcast(intent);
    }

}

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(null!=intent){
            String name = intent.getExtras().getString("name");
            Toast.makeText(context, "广播接收到:"+name, Toast.LENGTH_SHORT).show();
        }
    }
}&lt;/pre&gt; 
&lt;pre&gt;&lt;span style="color:#FF0000"&gt;AndroidManiFest.xml 的 &amp;lt;application&amp;gt;中添加&lt;/span&gt;

&amp;lt;receiver android:name=".MyReceiver"&amp;gt;
    &amp;lt;intent-filter android:priority="1000"&amp;gt; &amp;lt;!-- 设置最高优先级 --&amp;gt;
        &amp;lt;action android:name="com.xiazdong"/&amp;gt;
    &amp;lt;/intent-filter&amp;gt;
&amp;lt;/receiver&amp;gt;&lt;/pre&gt; 
&lt;p&gt;&amp;nbsp;&lt;/p&gt; 
&lt;p&gt;案例下载地址：&lt;a href="https://github.com/DickyQie/four-components.git" target="_blank" rel="nofollow"&gt;https://github.com/DickyQie/four-components.git&lt;/a&gt;&lt;/p&gt; </textarea>
			</div>
