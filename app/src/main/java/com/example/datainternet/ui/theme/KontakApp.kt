package com.example.datainternet.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.datainternet.ui.theme.home.HomeScreen
import com.example.datainternet.ui.theme.viewmodel.HomeViewModel

@Composable
fun KontakApp(
    homeViewModel: HomeViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val scroLLBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scroLLBehavior.nestedScrollConnection),
        topBar = { TopAppBar(scroLLBehavior = scroLLBehavior)}
    ){
        surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ){
            HomeScreen(kontakUIState = homeViewModel.KontakUIState,
                retryAction = homeViewModel::getKontak
            )
        }

        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        fun TopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier){
            CenterAlignedTopAppBar(
                scrollBehavior = scroLLBehavior,
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        style = MaterialTheme.typography.headlineSmall,
                        )
                },
                modifier = modifier
            )
        }
    }
}