package com.jameshill.photogallery.api
//This class maps to the outermost object in the json data.
//and connects is to the PhotoResponse class.
class FlickrResponse {
    lateinit var photos: PhotoResponse
}