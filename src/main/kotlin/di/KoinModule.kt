package com.wahid.di

import com.wahid.repository.HeroRepository
import com.wahid.repository.HeroRepositoryImpl
import org.koin.dsl.module

val koinModule = module {
    single<HeroRepository> {
        HeroRepositoryImpl()
    }
}