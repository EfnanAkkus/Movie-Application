

import android.util.Log
import com.example.movieapplication.data.modal.artist.Artist
import com.example.movieapplication.data.repository.artist.datasource.ArtistCacheDatasource
import com.example.movieapplication.data.repository.artist.datasource.ArtistLocalDatasource
import com.example.movieapplication.data.repository.artist.datasource.ArtistRemoteDatasource

import com.example.movieapplication.domain.repository.ArtistRepository
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistCacheDatasource: ArtistCacheDatasource,
    private val artistLocalDatasource: ArtistLocalDatasource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDatasource.clearAll()
        artistLocalDatasource.saveArtistsToDB(newListOfArtists)
        artistCacheDatasource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDatasource.getArtists()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (exception: Exception) {
            Log.i("My Tag", exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDatasource.getArtistsFromDB()

        } catch (exception: Exception) {
            Log.i("My Tag", exception.message.toString())
        }
        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistsFromAPI()
            artistLocalDatasource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDatasource.getArtistsFromCache()

        } catch (exception: Exception) {
            Log.i("My Tag", exception.message.toString())
        }
        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistsFromDB()
            artistCacheDatasource.saveArtistsToCache(artistList)
        }
        return artistList
    }
}