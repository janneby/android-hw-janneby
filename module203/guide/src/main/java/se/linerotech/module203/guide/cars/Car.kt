package se.linerotech.module203.guide.cars

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import se.linerotech.module203.guide.cars.dto.CarDto

@Parcelize
data class Car(
    val details: String,
    val image: String,
    val name: String,
    val pricePerDay: Int,
    val seat: Int,
    val transmission: String
) : Parcelable {
    constructor(dto: CarDto) : this(
        details = dto.details,
        image = dto.image,
        name = dto.name,
        pricePerDay = dto.pricePerDay,
        seat = dto.seat,
        transmission = dto.transmission
    )
}
