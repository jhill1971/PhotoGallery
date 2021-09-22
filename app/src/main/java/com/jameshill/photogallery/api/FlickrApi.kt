package com.jameshill.photogallery.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

// flickr api key: f37515f6505e1e7b574ee9e9ce3653ab

interface FlickrApi {
    @GET(
        "services/rest/?method=flickr.interestingness.getList" +
                "&api_key=f37515f6505e1e7b574ee9e9ce3653ab" +
                "&format=json" +
                "&nojsoncallback=1" +
                "&extras=url_s")
    fun fetchPhotos(): Call<FlickrResponse>
    @GET
    fun fetchUrlBytes(@Url url: String): Call<ResponseBody>
}

