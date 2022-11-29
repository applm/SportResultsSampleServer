package com.sportresultssample.data

import com.sportresultssample.model.SportResult

val sportResults = testInitSportResults()

fun testInitSportResults() : MutableMap<String, SportResult> {
    val sr = mutableMapOf<String, SportResult>()
    var id = java.util.UUID.randomUUID().toString()
    sr[id] = SportResult(
        uid = id,
        name = "Running",
        place = "Berlin",
        duration = "1:30"
    )
    id = java.util.UUID.randomUUID().toString()
    sr[id] = SportResult(
        uid = id,
        name = "Swimming",
        place = "Hamburg",
        duration = "2:30"
    )
    id = java.util.UUID.randomUUID().toString()
    sr[id] = SportResult(
        uid = id,
        name = "Cycling",
        place = "Munich",
        duration = "3:30"
    )
    return sr
}