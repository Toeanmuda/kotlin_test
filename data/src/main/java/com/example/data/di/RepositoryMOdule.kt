package com.example.data.di

import com.example.data.MainRepositoryImpl
import com.example.domain.MainRepository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryMOdule {

    @Singleton
    @Binds
    internal abstract fun bindRepository(repositoryImpl: MainRepositoryImpl): MainRepository
}
