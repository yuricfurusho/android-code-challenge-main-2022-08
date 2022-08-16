package com.yuricfurusho.localstorage

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

//TODO Yuri: LEAG-0012: research about correct scoping
@Module
@InstallIn(SingletonComponent::class)
class SharedPrefLeagueStorageProvider {

    @Provides
    fun providesSharedPrefLeagueStorage(
        @ApplicationContext context: Context
    ): SharedPreferences = context.getSharedPreferences(
        LeagueStorage.LEAGUE_PREF_FILE_KEY, Context.MODE_PRIVATE
    )
}
