package com.sportresultssample.repository

import com.sportresultssample.data.sportResults
import com.sportresultssample.model.SportResult
import com.sportresultssample.model.SportResultInput

class SportResultsRepository {

    @Synchronized
    fun addSportResult(sportResult: SportResult) {
        sportResults[sportResult.uid] = sportResult
    }

    @Synchronized
    fun getSportResult(uid: String): SportResult? {
        return sportResults[uid]
    }

    @Synchronized
    fun listSportResults(): List<SportResult> {
        return sportResults.values.toList()
    }

    @Synchronized
    fun updateSportResult(uid: String, sportResultInput: SportResultInput): SportResult {
        val sportResult = SportResult(
            uid = uid,
            name = sportResultInput.name,
            place = sportResultInput.place,
            duration = sportResultInput.duration
        )
        sportResults[uid] = sportResult
        return sportResult
    }
}