package se.linerotech.module203.guide.cars

sealed class CarsState {
    object Loading : CarsState()
    data class Success(val cars: List<Car>) : CarsState()
    object Failure : CarsState()
}
