package se.linerotech.module204.guide.repository.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TaskEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}

class DatabaseInstance private constructor() {
    companion object {
        private var instance: AppDatabase? = null

        fun instance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room
                    .databaseBuilder(context, AppDatabase::class.java, "AppDatabase")
                    .build()
            }

            return instance!!
        }
    }
}
