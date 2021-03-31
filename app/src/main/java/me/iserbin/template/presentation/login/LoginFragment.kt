package me.iserbin.template.presentation.login

import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import me.iserbin.common.arch.base.BaseFragment
import me.iserbin.ui.R
import timber.log.Timber

@AndroidEntryPoint
class LoginFragment : BaseFragment(R.layout.fragment_login) {

    private val viewModel by viewModels<LoginViewModel>()

    override fun bindViews(view: View) {
        Timber.d("-> args: view: $view")
    }

    override fun initUI() {
        Timber.d("-> ")
    }

    override fun initModel() {
        Timber.d("-> ")
    }
}