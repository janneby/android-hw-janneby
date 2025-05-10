package se.linerotech.module203.project2.stations

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import se.linerotech.module203.project2.stations.api.StationDTO

@Parcelize
data class Station(
    val id: Int = 0,
    val name: String = "",
    val url: String = "",
    val location: Location = Location(),
    val services: List<Service> = listOf()
) : Parcelable {

    @Parcelize
    data class Location(
        val name: String = "",
        val gps: String = ""
    ) : Parcelable

    @Parcelize
    data class Service(
        val name: String = ""
    ) : Parcelable

    constructor(dto: StationDTO) : this(
        id = dto.id ?: 0,
        name = dto.name ?: "",
        url = dto.url ?: "",
        location = Location(
            name = dto.location?.name ?: "",
            gps = dto.location?.gps ?: ""
        ),
        services = dto.services?.map { Service(it?.name ?: "") } ?: listOf()
    )
}
