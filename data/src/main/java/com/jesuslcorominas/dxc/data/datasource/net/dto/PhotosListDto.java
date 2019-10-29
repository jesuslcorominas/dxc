package com.jesuslcorominas.dxc.data.datasource.net.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotosListDto {

    // TODO si se quisiera hacer la paginacion habria que modificar esta clase para guardar datos
    // de la pagina actual y paginas totales

    @SerializedName("photo")
    private List<PhotoSearchResultDto> photos;

    public List<PhotoSearchResultDto> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoSearchResultDto> photos) {
        this.photos = photos;
    }
}
