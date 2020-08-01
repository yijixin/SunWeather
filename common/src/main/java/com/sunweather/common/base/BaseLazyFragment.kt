package com.sunweather.common.base

/**
 * @author yijixin on 2020/8/1
 * 懒加载的Fragment
 */
abstract class BaseLazyFragment : BaseFragment(){

    private var mIsFirstLoad = true

    override fun onResume() {
        super.onResume()

        if (mIsFirstLoad) {
            loadLazyData()
            mIsFirstLoad = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mIsFirstLoad = true
    }

    //懒加载加载数据的方法
    abstract fun loadLazyData()

}