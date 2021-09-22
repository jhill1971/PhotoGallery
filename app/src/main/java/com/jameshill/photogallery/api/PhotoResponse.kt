package com.jameshill.photogallery.api

import com.google.gson.annotations.SerializedName
import com.jameshill.photogallery.GalleryItem
//This class maps to the "photos" object in the json data
class PhotoResponse {
    @SerializedName("photo")
    lateinit var galleryItems: List<GalleryItem>
}