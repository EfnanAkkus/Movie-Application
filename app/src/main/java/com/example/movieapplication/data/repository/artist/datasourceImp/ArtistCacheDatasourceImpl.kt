
import com.example.movieapplication.data.modal.artist.Artist
import com.example.movieapplication.data.repository.artist.datasource.ArtistCacheDatasource

class ArtistCacheDatasourceImpl : ArtistCacheDatasource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList= ArrayList(artists)
    }
}