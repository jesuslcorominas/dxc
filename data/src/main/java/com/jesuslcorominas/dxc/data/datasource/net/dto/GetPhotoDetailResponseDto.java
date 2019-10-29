package com.jesuslcorominas.dxc.data.datasource.net.dto;

import com.google.gson.annotations.SerializedName;

public class GetPhotoDetailResponseDto {

    @SerializedName("photo")
    private PhotoDetailDto photoDetailDto;

    public PhotoDetailDto getPhotoDetailDto() {
        return photoDetailDto;
    }

    public void setPhotoDetailDto(PhotoDetailDto photoDetailDto) {
        this.photoDetailDto = photoDetailDto;
    }
}
