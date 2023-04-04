package com.example.pocserverperfwebflux.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class TransactionController {
    private var counter = 0

    @GetMapping("transaction", produces = [MediaType.TEXT_PLAIN_VALUE])
    fun transaction(): Mono<String> {
        return Mono.just(generateRandomTransaction())
    }

    fun generateRandomTransaction(): String {
        counter++
        val transactionTypes = listOf("deposit", "withdrawal", "transfer")
        val transactionIds = (counter + 100000..counter + 999999).random()

        val randomType = transactionTypes.random()
        return "$randomType #$transactionIds"
    }
}