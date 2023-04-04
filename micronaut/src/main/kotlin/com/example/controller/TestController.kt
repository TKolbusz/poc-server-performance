package com.example.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Produces


@Controller
class TestController {
    private var counter = 0

    @Get("transaction")
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): String {
        val transaction = generateRandomTransaction()
        return transaction
    }

    fun generateRandomTransaction(): String {
        counter++
        val transactionTypes = listOf("deposit", "withdrawal", "transfer")
        val transactionIds = (counter + 100000..counter + 999999).random()

        val randomType = transactionTypes.random()
        return "$randomType #$transactionIds"
    }
}