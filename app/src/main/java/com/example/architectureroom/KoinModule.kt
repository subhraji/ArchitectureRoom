package com.example.architectureroom

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { NoteRepository(get()) }
    viewModel { NoteViewModel(get()) }
}