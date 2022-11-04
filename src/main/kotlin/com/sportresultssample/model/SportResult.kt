package com.sportresultssample.model

data class SportResult(
    var uid: String,
    var name: String,
    var place: String,
    var duration: String
)

data class SportResultInput(
    var name: String,
    var place: String,
    var duration: String
)
