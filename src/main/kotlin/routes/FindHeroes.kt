package com.wahid.routes
import com.wahid.repository.HeroRepository
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Route.findHeroes(){

    val heroesRepository:HeroRepository by application.inject<HeroRepository>()


    get("$HEROES_URL/search"){
        val heroName = call.request.queryParameters["name"]
        val response = heroesRepository.searchHeroes(heroName)
        call.respond(
            status = HttpStatusCode.OK,
            message = response
        )

    }


}