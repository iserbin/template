package me.iserbin.common.arch.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment(layoutId: Int) : Fragment(layoutId) {

    protected abstract fun bindViews(view: View)
    protected abstract fun initUI()
    protected abstract fun initModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews(view)
        initUI()
        initModel()
    }
}
