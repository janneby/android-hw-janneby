package se.linerotech.module204.guide.home

import se.linerotech.module204.guide.repository.database.TaskEntity

data class Task(
    val id: String,
    val name: String,
    var isCompleted: Boolean,
) {
    constructor(taskEntity: TaskEntity) : this(
        id = taskEntity.id,
        name = taskEntity.name,
        isCompleted = taskEntity.isCompleted,
    )
}
