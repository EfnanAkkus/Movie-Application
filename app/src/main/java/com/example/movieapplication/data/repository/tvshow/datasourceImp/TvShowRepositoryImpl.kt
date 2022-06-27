

import android.util.Log
import com.example.movieapplication.data.modal.tvshow.TvShow
import com.example.movieapplication.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.example.movieapplication.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.example.movieapplication.data.repository.tvshow.datasource.TvShowRemoteDatasource

import com.example.movieapplication.domain.repository.TvShowRepository
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvShowRemoteDatasource: TvShowRemoteDatasource,
    private val tvShowCacheDatasource: TvShowCacheDatasource,
    private val tvShowLocalDatasource: TvShowLocalDatasource
) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDatasource.clearAll()
        tvShowLocalDatasource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDatasource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            val response = tvShowRemoteDatasource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvShowList = body.tvShows
            }
        } catch (exception: Exception) {
            Log.i("My Tag", exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getArtistsFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowLocalDatasource.getTvShowsFromDB()

        } catch (exception: Exception) {
            Log.i("My Tag", exception.message.toString())
        }
        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDatasource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowCacheDatasource.getTvShowsFromCache()

        } catch (exception: Exception) {
            Log.i("My Tag", exception.message.toString())
        }
        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getArtistsFromDB()
            tvShowCacheDatasource.saveTvShowsToCache(tvShowList)
        }
        return tvShowList
    }
}