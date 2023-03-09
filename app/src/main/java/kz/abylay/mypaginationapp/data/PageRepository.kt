package kz.abylay.mypaginationapp.data

import kotlinx.coroutines.delay

class PageRepository {

    private val remoteDataSource = (1..100).map {
        PageData(
            title = "Item $it",
            description = "Description $it"
        )
    }

    suspend fun getItems(page: Int, pageSize: Int): Result<List<PageData>> {
        delay(DELAY)
        val startingIndex = page * pageSize
        return if (startingIndex + pageSize <= remoteDataSource.size) {
            Result.success(remoteDataSource.slice(startingIndex until startingIndex + pageSize))
        } else {
            Result.success(emptyList())
        }
    }

    companion object {
        private const val DELAY = 1000L
    }
}