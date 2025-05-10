package se.linerotech.module203.project2.api

import retrofit2.Call
import retrofit2.http.GET
import se.linerotech.module203.project2.incidents.api.IncidentDTO
import se.linerotech.module203.project2.stations.api.StationDTO

interface Endpoint {

    // https://polisen.se/api/events
    @GET("events")
    fun events(): Call<List<IncidentDTO>>

    // https://polisen.se/api/policestations
    @GET("policestations")
    fun stations(): Call<List<StationDTO>>
}
