package se.linerotech.module203.project2.incidents

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import se.linerotech.module203.project2.incidents.api.IncidentDTO

@Parcelize
data class Incident(
    val id: Int? = 0,
    val datetime: String? = "",
    val name: String? = "",
    val summary: String? = "",
    val url: String? = "",
    val type: String? = "",
    val location: Location? = Location()
) : Parcelable {
    constructor(dto: IncidentDTO) : this(
        id = dto.id,
        datetime = dto.datetime,
        name = dto.name,
        summary = dto.summary,
        url = dto.url,
        type = dto.type,
        location = dto.location?.let { Location(it) }
    )

    @Parcelize
    data class Location(
        val name: String? = "",
        val gps: String? = ""
    ) : Parcelable {
        constructor(dto: IncidentDTO.Location) : this(
            name = dto.name,
            gps = dto.gps
        )
    }
}
