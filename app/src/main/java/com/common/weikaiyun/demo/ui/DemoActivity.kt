package com.common.weikaiyun.demo.ui

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.common.weikaiyun.R
import com.common.weikaiyun.demo.db.User
import com.common.weikaiyun.demo.viewmodel.UserViewModel
import com.weikaiyun.fragmentation.BaseActivity

class DemoActivity : BaseActivity() {

    override fun getContentViewID(): Int = R.layout.activity_demo

    override fun initData(savedInstanceState: Bundle?) {
        val viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModel.userList.observe(this, Observer {
            it.forEach() { user ->
                Log.i("User Info", user.toString())
            }
        })

        val user1 = User(1, "1", 1,  1, 1, "1")
        val user2 = User(2, "2", 2,  2, 2, "2")
        val user3 = User(3, "3", 3,  3, 3, "3")
        val user4 = User(4, "4", 4,  4, 4, "4")
        val user5 = User(5, "5", 5,  5, 5, "5")

        viewModel.updateAll(user1, user2, user3, user4, user5)

        lifecycleScope.launchWhenCreated {

        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        loadRootFragment(R.id.container, DemoFragment1.newInstance(1, "start2"))
    }
}
