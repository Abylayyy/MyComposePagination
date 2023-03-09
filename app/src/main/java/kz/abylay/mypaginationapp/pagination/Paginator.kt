package kz.abylay.mypaginationapp.pagination

interface Paginator<Item> {
    suspend fun loadNextItems()
    fun reset()
}