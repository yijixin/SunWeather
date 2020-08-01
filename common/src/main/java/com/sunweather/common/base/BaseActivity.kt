package com.sunweather.common.base

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sunweather.common.observer.MyObserver
import com.sunweather.common.utils.ActivityCollector

/**
 * @author yijixin on 2020/8/1
 * 继承于此基本的Activity
 */
abstract class BaseActivity : AppCompatActivity(){

    companion object {
        val TAG = javaClass.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCollector.addActivity(this)
        setContentView(layoutId())

        Log.d(TAG, javaClass.simpleName)
        lifecycle.addObserver(MyObserver(lifecycle))

        initView()

    }

    abstract fun layoutId() : Int

    abstract fun initView()

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }

}