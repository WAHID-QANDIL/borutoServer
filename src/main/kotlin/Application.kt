package com.wahid

import com.wahid.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}
@Suppress("unused")
fun Application.module() {
    configureKoin()
    configureRouting()
    configureMonitoring()
    configureSerialization()
    configureDefaultHeader()
    configureStatusPages()
}
