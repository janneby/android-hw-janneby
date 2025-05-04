package se.linerotech.module203.guide.hotels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import se.linerotech.module203.guide.hotels.dto.HotelDto

@Parcelize
data class Hotel(
    val name: String,
    val reviews: Int,
    val stars: Int,
    val pricePerNight: Int,
    val details: String,
    val image: String
) : Parcelable {
    constructor(dto: HotelDto) : this(
        name = dto.name,
        reviews = dto.reviews,
        stars = dto.stars,
        pricePerNight = dto.pricePerNight,
        details = dto.details,
        image = dto.image,
    )
}
