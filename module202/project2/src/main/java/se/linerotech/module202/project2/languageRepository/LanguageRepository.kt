package se.linerotech.module202.project2.languageRepository

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import se.linerotech.module202.project2.api.LanguageResultDto

@Parcelize
data class LanguageRepository(
    val title: String,
    val description: String,
    val language: String,
    val date: String,
    val license: String,
) : Parcelable {

    constructor(dto: LanguageResultDto.Item) : this(
        title = dto.owner?.login.toString(),
        description = dto.description.toString(),
        language = dto.language.toString(),
        date = dto.updatedAt.toString(),
        license = dto.license?.spdxId.toString(),
    )
}
