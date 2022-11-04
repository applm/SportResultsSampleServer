package com.sportresultssample.schema

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.sportresultssample.model.SportResult
import com.sportresultssample.model.SportResultInput
import com.sportresultssample.repository.SportResultsRepository

fun SchemaBuilder.sportResultSchema() {

    val repository = SportResultsRepository()

    query("getSportResult") {
        description = "Get a sport result by uid"
        resolver { uid:String -> repository.getSportResult(uid) }
    }

    query("listSportResults") {
        description = "List all sport results"
        resolver { -> repository.listSportResults() }
    }

    mutation("addSportResult") {
        description = "Add a sport result"
        resolver { sportResultInput: SportResultInput ->
            val uid = java.util.UUID.randomUUID().toString()
            val sportResult = SportResult(
                uid = uid,
                name = sportResultInput.name,
                place = sportResultInput.place,
                duration = sportResultInput.duration
            )
            try {
                repository.addSportResult(sportResult)
                sportResult
            } catch (e: Exception) {
                null
            }
        }
    }

    mutation("updateSportResult") {
        description = "Update a sport result"
        resolver { uid: String, sportResultInput: SportResultInput ->
            try {
                repository.updateSportResult(uid, sportResultInput)
            } catch (e: Exception) {
                null
            }
        }
    }

    inputType<SportResultInput> {
        description = "Input of a sport result without id"
    }

    type<SportResult> {
        description = "A sport result with attributes name, place and duration"
    }
}