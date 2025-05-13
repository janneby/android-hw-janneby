package se.linerotech.module204.guide.repository.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {

    // Getting all the tasks
    @Query("SELECT * FROM tasks")
    suspend fun get(): List<TaskEntity>

    // Getting the completed tasks
    @Query("SELECT * FROM tasks WHERE is_completed = 1")
    suspend fun completedTasks(): List<TaskEntity>

    // Getting the incompleted tasks
    @Query("SELECT * FROM tasks WHERE is_completed = 0")
    suspend fun notCompletedTasks(): List<TaskEntity>

    // Inserting tasks
    @Insert
    suspend fun insert(task: TaskEntity)

    // Updating existing tasks
    @Update
    suspend fun update(task: TaskEntity)
}
