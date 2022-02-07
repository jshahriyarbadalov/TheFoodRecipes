package com.shahriyar.foodrecipes.data

import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(
    remoteDataSource: RemoteDataSource,
    localeDataSource: LocaleDataSource
) {
    val remote=remoteDataSource
    val local=localeDataSource
}