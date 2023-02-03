package com.ozancanguz.weatherapp.data

import com.ozancanguz.weatherapp.data.remote.RemoteDataSource
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class Repository@Inject constructor(private var remoteDataSource: RemoteDataSource) {

    val remote=remoteDataSource

}