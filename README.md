# Performance comparison between Ktor, Micronaut  and Spring Webflux for simple endpoint

## Endpoint
/transaction endpoint enerates random number with a prefix
```kotlin
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
```

## Method

1. Run the application inside docker container with 1 CPU and 512MB of RAM
2. Perform measurement using JMeter
3. Stop the application
4. Evaluate results

## Running the applications

Application endpoint is available at
```
localhost:8080/transaction
```

### Ktor

```
cd ktor
```
```
./gradlew buildFatJar
```
```
docker build -t ktor .
```
```
docker compose up
```

### Micronaut
```
cd micronaut
```

```
./gradlew build
```
```
docker build -t micronaut .
```
```
docker compose up
```

### Spring WebFlux

```
cd webflux
```
```
./gradlew build
```
```
docker build -t webflux .
```
```
docker compose up
```