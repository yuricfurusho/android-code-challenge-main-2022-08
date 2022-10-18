package com.yuricfurusho.league

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//TODO Yuri: LEAG-0011: research about adequate place store hilt modules and their organization
// right now because we are doing this here the app module requested domain-repo-interface as a dependency
//TODO Yuri: LEAG-0012: research about correct scoping
@Module
@InstallIn(SingletonComponent::class)
class LeagueApiProvider {

    @Provides
    fun providesLeagueApi(): LeagueApi = Retrofit.Builder()
        .baseUrl(LeagueApi.HOST)
        .addConverterFactory(GsonConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(LeagueApi::class.java)
}