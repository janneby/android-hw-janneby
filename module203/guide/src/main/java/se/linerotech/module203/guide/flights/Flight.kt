package se.linerotech.module203.guide.flights

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import se.linerotech.module203.guide.flights.dto.FlightDto

@Parcelize
data class Flight(
    val from: String,
    val to: String,
    val durationInHours: Int,
    val departure: String,
    val arrival: String,
    val price: Double,
    val stops: Int,
) : Parcelable {
    constructor(dto: FlightDto) : this(
        from = dto.from,
        to = dto.to,
        durationInHours = dto.durationInHours,
        departure = dto.departure,
        arrival = dto.arrival,
        price = dto.price,
        stops = dto.stops,
    )
}
