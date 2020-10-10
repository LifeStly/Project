package com.example.moveproject.data.MovieRepository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moveproject.data.MovieApi.TheMovieDBInterface
import com.example.moveproject.data.MovieDetail.MovieDetailData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

//เเช๋คการดึกข้อมูลจาก net
class MovieDetailNetworkDataSource (private val apiService : TheMovieDBInterface, private val compositeDisposable: CompositeDisposable){
    private val _networkState = MutableLiveData<NetworkState>()
    val networkState:LiveData<NetworkState>
        get() = _networkState

    //ดึงข้อมูลจาก net
    private val _downloadMovieDetailsResponse = MutableLiveData<MovieDetailData>()
    val downloadedMovieResponse: LiveData<MovieDetailData>
        get() = _downloadMovieDetailsResponse

    //ดึงข้อมูลรายละเยียดหนัง
    fun fetchMovieDetailData(movieId: Int){
        _networkState.postValue(NetworkState.LOADING)

        try {
            compositeDisposable.add(
                apiService.getMovieDetailData(movieId)
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {
                            _downloadMovieDetailsResponse.postValue(it)
                            _networkState.postValue(NetworkState.LOADED)
                        },
                        {
                            _networkState.postValue(NetworkState.ERROR)
                            Log.e("MovieDetailsDataSource", it.message)
                        }
                    )
            )
        }
        catch (e: Exception){
            Log.e("MovieDetailDataSource", e.message)
        }
    }
}