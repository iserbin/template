package me.iserbin.template.presentation.login

import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import me.iserbin.common.arch.base.BaseFragment
import me.iserbin.common.arch.setOnSingleClick
import me.iserbin.ui.R
import timber.log.Timber

@AndroidEntryPoint
class LoginFragment : BaseFragment(R.layout.fragment_login) {

    private val viewModel by viewModels<LoginViewModel>()
    private lateinit var editTextUserName: EditText
    private lateinit var editTextTextPassword: EditText
    private lateinit var button: Button

    override fun bindViews(view: View) {
        editTextUserName = view.findViewById(R.id.editTextUserName)
        editTextTextPassword = view.findViewById(R.id.editTextTextPassword)
        button = view.findViewById(R.id.button)
    }

    override fun initUI() {
        button.setOnSingleClick {
            viewModel.onButtonClicked(
                name = editTextUserName.text.toString().trim(),
                password = editTextTextPassword.text.toString().trim(),
            )
        }
    }

    override fun initModel() {
        Timber.d("-> ")
    }
}
