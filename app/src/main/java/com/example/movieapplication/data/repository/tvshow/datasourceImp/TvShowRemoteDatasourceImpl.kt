
import com.example.movieapplication.data.api.TMDBService
import com.example.movieapplication.data.modal.tvshow.TvShowList
import com.example.movieapplication.data.repository.tvshow.datasource.TvShowRemoteDatasource

import retrofit2.Response

class TvShowRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowRemoteDatasource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShow(apiKey)

}