package com.wahid.routes

import com.wahid.modle.ApiResponse
import com.wahid.repository.HeroRepository
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
const val HEROES_URL = "boruto/heroes"
fun Route.getAllHeroes() {

    val heroesRepository: HeroRepository by application.inject()
    get(HEROES_URL)
    {
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            if (page !in 1.. 5) throw IllegalArgumentException()

            val response = heroesRepository.getAllHeroes(pageNumber = page)

            call.respond(
                status = HttpStatusCode.OK,
                message = response
            )
        } catch (e: NumberFormatException) {
            call.respond(
                status = HttpStatusCode.BadRequest,
                message = ApiResponse(false, message = "Only Numbers Allowed")
            )
        } catch (e: IllegalArgumentException) {
            call.respond(
                status = HttpStatusCode.NotFound,
                message = ApiResponse(false, message = "Only Numbers From 1 to 5")
            )

        }

    }

}