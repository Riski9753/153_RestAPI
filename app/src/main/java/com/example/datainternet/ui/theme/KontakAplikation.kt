package com.example.datainternet.ui.theme

import com.example.datainternet.revository.AppContainer
import com.example.datainternet.revository.KontakContainer

class KontakAplikation {
    lateinit var container: AppContainer

    override fun onCreate(){
        super.onCreate()
        container = KontakContainer()
    }
}