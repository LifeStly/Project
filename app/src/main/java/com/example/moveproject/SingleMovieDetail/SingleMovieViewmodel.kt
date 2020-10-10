package com.example.moveproject.SingleMovieDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moveproject.data.MovieDetail.MovieDetailData
import com.example.moveproject.data.MovieRepository.NetworkState
import io.reactivex.disposables.CompositeDisposable
//แสดงผล ซึ่งดึงข้อมูลมาจาก MovieDetailRepository
class SingleMovieViewmodel (private val movieRepository : MovieDetailRepository,movieInt: Int) : ViewModel(){

    //compositableDisposable จัดการส่วนประกอบของหนัง
    private val compositeDisposable = CompositeDisposable()

    val movieDetailData : LiveData<MovieDetailData> by lazy {
        movieRepository.fetchSingleMovieDetails(compositeDisposable,movieInt)
    }
    val networkState : LiveData<NetworkState> by lazy {
        movieRepository.getMovieDetailNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()//dispose ทิ้งรายละเอียด
    }
}