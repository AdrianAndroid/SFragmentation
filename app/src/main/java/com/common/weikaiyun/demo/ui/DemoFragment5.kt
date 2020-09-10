package com.common.weikaiyun.demo.ui

import android.os.Bundle
import android.view.View
import com.common.weikaiyun.R
import com.weikaiyun.fragmentation.BaseFragment
import com.weikaiyun.fragmentation.fragmentargument.argument
import kotlinx.android.synthetic.main.fragment_demo.*

class DemoFragment5: BaseFragment() {
    private var param1: Int by argument()
    private var param2: String by argument()
    companion object {
        fun newInstance(param1: Int, param2: String): DemoFragment5 =
            DemoFragment5().apply {
                this.param1 = param1
                this.param2 = param2
            }
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        title.text = "DemoFragment$param1"
        button.text = param2
    }

    override fun getLayoutId(): Int = R.layout.fragment_demo
}