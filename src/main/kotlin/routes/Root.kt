package com.wahid.routes

import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

const val BASE_URL = "/"

fun Route.root()
{
    get(BASE_URL)
    {
        call.respond(status = HttpStatusCode.OK, message = "Welcome to Boruto API!")
    }
}