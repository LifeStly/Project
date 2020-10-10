package com.example.moveproject.data.MovieRepository

enum class Status{
    RUNING,
    SUCCESS,
    FAILED
}
class NetworkState (val status : Status, val msg:String){
    companion object{
        val LOADED: NetworkState = NetworkState(Status.SUCCESS, "Success")
        val LOADING: NetworkState = NetworkState(Status.RUNING, "Running")
        val ERROR: NetworkState = NetworkState(Status.FAILED,"Something went wrong")

    }
}