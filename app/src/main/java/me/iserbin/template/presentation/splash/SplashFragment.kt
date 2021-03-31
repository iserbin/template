package me.iserbin.template.presentation.splash

import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import me.iserbin.common.arch.base.BaseFragment
import me.iserbin.ui.R
import timber.log.Timber

@AndroidEntryPoint
class SplashFragment : BaseFragment(R.layout.fragment_splash) {

    private val viewModel by viewModels<SplashViewModel>()

    override fun bindViews(view: View) {
        Timber.d("-> args: view: $view")
    }

    override fun initUI() {
        Timber.d("-> ")
    }

    override fun initModel() {
        viewModel.checkRegistration()
    }
}
