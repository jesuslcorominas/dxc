package com.jesuslcorominas.dxc.data.datasource.net.dto;

import com.google.gson.annotations.SerializedName;

public class SearchResponseDto {

    @SerializedName("photos")
    private PhotosListDto photosListDto;

    public PhotosListDto getPhotosListDto() {
        return photosListDto;
    }

    public void setPhotosListDto(PhotosListDto photosListDto) {
        this.photosListDto = photosListDto;
    }
}
