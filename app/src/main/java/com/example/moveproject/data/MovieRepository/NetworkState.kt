package com.example.moveproject.data.MovieRepository

enum class Status{
    RUNING,SUCCESS,FAILED
}
class NetworkState (val status : Status, val msg:String){
    companion object{
        val LOADED: NetworkState
        val LOADING: NetworkState
        val ERROR: NetworkState

        init {
            LOADED = NetworkState(Status.SUCCESS, "Success")
            LOADING = NetworkState(Status.RUNING, "Running")
            ERROR = NetworkState(Status.FAILED,"Something went wrong")
        }
    }
}