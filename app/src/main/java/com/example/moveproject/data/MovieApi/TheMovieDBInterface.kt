package com.example.moveproject.data.MovieApi

import com.example.moveproject.data.MovieDetail.MovieDetailData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Part

interface TheMovieDBInterface {

    // ตั้ง path การต้นหาข้อมูลให้เข้าไปที่ movie จากนั้นให้ get id
    @GET("movie/{movie_id}")
    fun getMovieDetailData(@Part("movie_id") id: Int): Single<MovieDetailData>
}