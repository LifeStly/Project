package com.example.moveproject.SingleMovieDetail

import androidx.lifecycle.LiveData
import com.example.moveproject.data.MovieApi.TheMovieDBInterface
import com.example.moveproject.data.MovieDetail.MovieDetailData
import com.example.moveproject.data.MovieRepository.MovieDetailNetworkDataSource
import com.example.moveproject.data.MovieRepository.NetworkState
import io.reactivex.disposables.CompositeDisposable

//เก็บข้อมูลที่ดึงมาจาก net
class MovieDetailRepository (private  val apiService: TheMovieDBInterface) {
    lateinit var movieDetailNetworkDataSource: MovieDetailNetworkDataSource
    //ข้อมูล ของหนัง
    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetailData>{
        movieDetailNetworkDataSource = MovieDetailNetworkDataSource(apiService, compositeDisposable)
        movieDetailNetworkDataSource.fetchMovieDetailData(movieId)

        return movieDetailNetworkDataSource.downloadedMovieResponse
    }
    //ข้อมูลขอวง state ว่า load หรืออะไร
    fun getMovieDetailNetworkState():LiveData<NetworkState>{
        return movieDetailNetworkDataSource.networkState
    }
}