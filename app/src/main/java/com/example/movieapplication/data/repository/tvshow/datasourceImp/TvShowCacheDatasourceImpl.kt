
import com.example.movieapplication.data.modal.tvshow.TvShow
import com.example.movieapplication.data.repository.tvshow.datasource.TvShowCacheDatasource

class TvShowCacheDatasourceImpl : TvShowCacheDatasource {
    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList= ArrayList(tvShows)
    }
}