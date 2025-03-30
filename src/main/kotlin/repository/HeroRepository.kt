package com.wahid.repository

import com.wahid.modle.ApiResponse
import com.wahid.modle.Hero

interface HeroRepository {
    val heroes:Map<Int,List<Hero>>
    val page1:List<Hero>
    val page2:List<Hero>
    val page3:List<Hero>
    val page4:List<Hero>
    val page5:List<Hero>

    suspend fun getAllHeroes(pageNumber:Int = 1):ApiResponse
    suspend fun searchHeroes(name:String?):ApiResponse
}