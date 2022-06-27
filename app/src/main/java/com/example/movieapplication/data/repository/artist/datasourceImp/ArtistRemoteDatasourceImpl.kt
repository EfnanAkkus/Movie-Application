
import com.example.movieapplication.data.api.TMDBService
import com.example.movieapplication.data.modal.artist.ArtistList
import com.example.movieapplication.data.repository.artist.datasource.ArtistRemoteDatasource

import retrofit2.Response

class ArtistRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDatasource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtist(apiKey)

}