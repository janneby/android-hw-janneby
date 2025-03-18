package se.linerotech.module202.lecture

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    val flagUrl: String,
    val countryName: String,
    val worldRegion: String,
    val population: String,
    val area: String,
    val capital: String,
    val callingCode: String,
    val topLevelDomain: String,
) : Parcelable {

    constructor(dto: MainCountryDTO.Country) : this(
        flagUrl = dto.flag.large ?: "",
        countryName = dto.name ?: "",
        worldRegion = dto.region ?: "",
        population = dto.population.toString() ?: "",
        area = dto.area.toString() ?: "",
        capital = dto.capital ?: "",
        callingCode = dto.callingCode ?: "",
        topLevelDomain = dto.topLevelDomain.toString() ?: "",
    )
}
