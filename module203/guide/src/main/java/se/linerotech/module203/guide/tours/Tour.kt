package se.linerotech.module203.guide.tours

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import se.linerotech.module203.guide.tours.dto.TourDto

@Parcelize
data class Tour(
    val name: String,
    val location: String,
    val days: Int,
    val cost: Int,
    val image: String,
) : Parcelable {
    constructor(dto: TourDto) : this(
        name = dto.title,
        location = dto.location,
        days = dto.days,
        cost = dto.price,
        image = dto.image,
    )
}
