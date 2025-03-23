package se.linerotech.module202.project1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import se.linerotech.module202.project1.api.CityWeatherDTO

@Parcelize
data class CityWeather(
    val tempC: Double,
    val weatherCondition: String,
    val cloud: Int,
    val humidity: Int,
    val uvIndex: Double

) : Parcelable {

    constructor(dto: CityWeatherDTO) : this(
        tempC = (dto.current?.tempC ?: "") as Double,
        weatherCondition = dto.current?.condition?.text ?: "",
        cloud = (dto.current?.cloud ?: "") as Int,
        humidity = (dto.current?.humidity ?: "") as Int,
        uvIndex = (dto.current?.uv ?: "") as Double,
    )
}
