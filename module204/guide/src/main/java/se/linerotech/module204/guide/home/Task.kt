package se.linerotech.module204.guide.home

data class Task(
    val id: String,
    val name: String,
    var isCompleted: Boolean,
)
