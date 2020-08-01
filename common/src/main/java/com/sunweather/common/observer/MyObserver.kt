package com.sunweather.common.observer

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * @author yijixin on 2020/8/1
 * 监听生命周期
 */
class MyObserver(val lifeCycle : Lifecycle) : LifecycleObserver{

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun activityStart()  {
        Log.d("MyObserver","activityStart--->${lifeCycle.currentState}")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun activityStop() {
        Log.d("MyObserver","activityStop---->${lifeCycle.currentState}")
    }

}