package com.abhinay.routes

import com.abhinay.data.model.Rabbit
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*


private const val BASE_URL = "http://192.168.1.10:8080"

private val rabbits = listOf(
    Rabbit("Carl", "A cute brown rabbit", "$BASE_URL/static/rabbits/rabbit1.jpg"),
    Rabbit("Emma", "Emma likes to eat apples", "$BASE_URL/static/rabbits/rabbit2.jpg"),
    Rabbit("Florian", "Florian is always hungry", "$BASE_URL/static/rabbits/rabbit3.jpg"),
    Rabbit("Federico", "Federico likes to climb mountains", "$BASE_URL/static/rabbits/rabbit4.jpg"),
    Rabbit("Gina", "Gina is a true beauty", "$BASE_URL/static/rabbits/rabbit5.jpg"),
)

fun Route.randomRabbit() {

    get("/randomrabbit") {

        call.respond(
            HttpStatusCode.OK,
            rabbits.random()
        )

    }

}