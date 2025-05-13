package se.linerotech.module204.guide.repository.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import se.linerotech.module204.guide.home.Task

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "is_completed")val isCompleted: Boolean
) {
    constructor(task: Task) : this(
        id = task.id,
        name = task.name,
        isCompleted = task.isCompleted,

    )
}
