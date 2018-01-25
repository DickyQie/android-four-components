#### Broadcas（广播）

广播 :在Android中，Broadcast是一种广泛运用的在应用程序之间传输信息的机制。我们拿广播电台来做个比方。我们平常使用收音机收音是这样的：许许多多不同的广播电台通过特定的频率来发送他们的内容，而我们用户只需要将频率调成和广播电台的一样就可以收听他们的内容了。Android中的广播机制就和这个差不多的道理,Android广播分为两个方面：广播发送者和广播接收者，通常情况下，BroadcastReceiver指的就是广播接收者（广播接收器）。

 

从实现原理看上，Android中的广播使用了观察者模式，基于消息的发布/订阅事件模型。因此，从实现的角度来看，Android中的广播将广播的发送者和接受者极大程度上解耦，使得系统能够方便集成，更易扩展。具体实现流程要点粗略概括如下：

1.广播接收者BroadcastReceiver通过Binder机制向AMS(Activity Manager Service)进行注册；

2.广播发送者通过binder机制向AMS发送广播；

3.AMS查找符合相应条件（IntentFilter/Permission等）的BroadcastReceiver，将广播发送到BroadcastReceiver（一般情况下是Activity）相应的消息循环队列中；

4.消息循环执行拿到此广播，回调BroadcastReceiver中的onReceive()方法。
