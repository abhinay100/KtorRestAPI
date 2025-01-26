package com.abhinay

import com.abhinay.routes.randomRabbit
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.calllogging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.slf4j.event.*

fun Application.configureRouting() {
    routing {
        randomRabbit()
        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")
    }
}
