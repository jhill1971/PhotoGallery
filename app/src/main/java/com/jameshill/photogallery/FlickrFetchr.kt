package com.jameshill.photogallery

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jameshill.photogallery.api.FlickrApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val TAG = "FlickrFetchr"

class FlickrFetchr {
    private val flickrApi: FlickrApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/")//endpoint
            //creates instance of the Scalars Converter Factory
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()//command to return a retrofit instance based on the
        //settings you specified using the builder object.
        flickrApi = retrofit.create(FlickrApi::class.java)
        //creates and instantiates an anonymous class that implements the interface.
    }

    fun fetchPhotos(): LiveData<String> {
        val responseLiveData: MutableLiveData<String> = MutableLiveData()
        val flickrRequest: Call<String> = flickrApi.fetchPhotos()
        //FetchContents() generates a retrofit call object representing an executable web request.
        val flickrHomePageRequest: Call<String> = flickrApi.fetchPhotos()

        //Executing the Request Asynchronously
        flickrHomePageRequest.enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e(TAG, "Failed to fetch photos", t)
            }

            override fun onResponse(
                call: Call<String>,
                response: Response<String>
            ) {
                Log.d(TAG, "Response received: $(response.body()")
            }
        })
        return responseLiveData
    }
}