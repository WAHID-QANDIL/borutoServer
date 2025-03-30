package com.wahid.plugins

import com.wahid.routes.findHeroes
import com.wahid.routes.getAllHeroes
import com.wahid.routes.root
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        root()
        findHeroes()
        getAllHeroes()
        staticResources("/images","images")


    }
}
