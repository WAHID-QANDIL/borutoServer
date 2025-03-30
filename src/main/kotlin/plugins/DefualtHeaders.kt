package com.wahid.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.defaultheaders.*

fun Application.configureDefaultHeader()
{
    install(DefaultHeaders){
        val oneYearInSeconds = java.time.Duration.ofDays(365).seconds
        header(
            name =HttpHeaders.CacheControl,
            value = "public, max-age=$oneYearInSeconds, immutable"
        )

    }
}