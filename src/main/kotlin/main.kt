package com.acme

import io.ktor.server.engine.embeddedServer
import io.ktor.server.html.respondHtml
import io.ktor.server.netty.Netty
import io.ktor.server.routing.*
import kotlinx.html.*

val DWARVES = listOf(
    "Doc",
    "Grumpy",
    "Happy",
    "Sleepy",
    "Bashful",
    "Sneezy",
    "Dopey",
)

fun main() {
    embeddedServer(Netty, port = 8080) {
        routing {
            get {
                call.respondHtml {
                    head {
                        style {
                            +"""
                                body {
                                    font-family: sans-serif;
                                }
                                code {
                                    color: #6c8;
                                    font-weight: bold;
                                    font-size: 1.2em;
                                    background-color: #333;
                                    padding: 0.2em 0.4em;
                                }
                            """.trimIndent()
                        }
                    }
                    body {
                        h1 { +"Dev Mode++" }
                        p { +"This project features the new dev mode for Ktor." }
                        p {
                            span {
                                +"Start by executing with the "
                            }
                            code {
                                +"runHot"
                            }
                            span {
                                +" gradle task."
                            }
                        }
                        p {
                            +"While the server is running, make some changes to the code and watch them reflected in the page."
                        }
                        br {}

                        h2 { +"Dwarves"}
                        ul {
                            for (dwarf in DWARVES) {
                                li { +dwarf }
                            }
                        }
                    }
                }
            }
        }
    }.start(wait = true)
}
