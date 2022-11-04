package com.sportresultssample

import com.apurebase.kgraphql.GraphQL
import com.apurebase.kgraphql.KGraphQL
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.sportresultssample.plugins.*
import com.sportresultssample.schema.sportResultSchema

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module(testing: Boolean = false) {
    install(GraphQL) {
        configureRouting()
        playground = true
        schema {
            sportResultSchema()
        }
    }
}
