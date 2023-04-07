package com.youssef.compose_practise.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Named

@Module
@InstallIn(ActivityComponent::class)
object MyModule {

  //  @Named("userId")
    @Provides
    fun provideMyString(): String {
        return "Hello, Dagger Hilt!"
    }

/*    @Named("userId2")
    @Provides
    fun provideMyString2(): String {
        return "Hello, Dagger Hilt! 2"
    }*/
}