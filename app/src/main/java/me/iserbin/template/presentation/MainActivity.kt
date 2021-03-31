package me.iserbin.template.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.iserbin.common.navigation.NavigationDispatcher
import me.iserbin.template.R
import javax.inject.Inject

@OptIn(InternalCoroutinesApi::class)
@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    @Inject
    lateinit var navigationDispatcher: NavigationDispatcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavigation()
    }

    private fun initNavigation() {
        lifecycleScope.launch {
            navigationDispatcher.navigationCommands.collect { command ->
                command.invoke(
                    Navigation.findNavController(
                        this@MainActivity,
                        R.id.nav_host
                    )
                )
            }
        }
    }
}
