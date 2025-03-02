package se.linerotech.module202.guide.common

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import se.linerotech.module202.guide.api.ArticleDTO

private const val ZERO_INT_VALUE = 0
private const val TEN_INT_VALUE = 0

@Parcelize
data class News(
    val title: String,
    val date: String,
    val source: String,
    val imageSource: String,
    val image: String,
    val description: String,
    val url: String,
) : Parcelable {

    constructor(dto: ArticleDTO) : this(
        title = dto.title ?: "",
        date = dto.pubDate?.substring(ZERO_INT_VALUE, TEN_INT_VALUE) ?: "",
        source = dto.sourceName ?: "",
        imageSource = dto.sourceUrl ?: "",
        image = dto.imageUrl ?: "",
        description = dto.description ?: "",
        url = dto.link ?: "linerotech.se",
    )
}
