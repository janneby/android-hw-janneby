package se.linerotech.module204.guide.repository.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import se.linerotech.module204.guide.repository.datastore

class UserDetailsRepository(context: Context) {
    private object Keys {
        val NAME_KEY = stringPreferencesKey("NAME_KEY")
        val EMAIL_KEY = stringPreferencesKey("EMAIL_KEY")
        val USERNAME_KEY = stringPreferencesKey("USERNAME_KEY")
    }

    private val dataSource = context.datastore

    suspend fun get(): UserDetails? {
        return dataSource.data.catch {
            emit(emptyPreferences())
        }.map { preferences ->
            val name = preferences[Keys.NAME_KEY] ?: ""
            val email = preferences[Keys.EMAIL_KEY] ?: ""
            val username = preferences[Keys.USERNAME_KEY] ?: ""

            return@map if (name.isEmpty() || email.isEmpty() || username.isEmpty()) {
                null
            } else {
                UserDetails(name = name, email = email, username = username)
            }
        }.first()
    }

    suspend fun put(userDetails: UserDetails): Boolean {
        val result = kotlin.runCatching {
            dataSource.edit { preferences ->
                preferences[Keys.NAME_KEY] = userDetails.name
                preferences[Keys.USERNAME_KEY] = userDetails.username
                preferences[Keys.EMAIL_KEY] = userDetails.email
            }
        }

        return result.isSuccess
    }
}