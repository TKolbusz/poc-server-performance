package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


private var counter = 0
fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    routing {
        get("/transaction") {
            val transaction = generateRandomTransaction()
            call.respond(transaction)
        }
    }
}

fun generateRandomTransaction(): String {
    counter++
    val transactionTypes = listOf("deposit", "withdrawal", "transfer")
    val transactionIds = (counter+100000..counter+999999).random()

    val randomType = transactionTypes.random()
    return "$randomType #$transactionIds"
}