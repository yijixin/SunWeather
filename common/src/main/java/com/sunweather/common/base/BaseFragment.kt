package com.sunweather.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sunweather.common.observer.MyObserver

/**
 * @author yijixin on 2020/6/8
 * 公共的Fragment
 */
abstract class BaseFragment : Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            initParams(it)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId(),container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        lifecycle.addObserver(MyObserver(lifecycle))
        initData()
    }

    abstract fun layoutId() : Int

    abstract fun initParams(bundle : Bundle)

    abstract fun initData()
}