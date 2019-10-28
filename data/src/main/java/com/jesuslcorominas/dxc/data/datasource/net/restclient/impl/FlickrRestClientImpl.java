package com.jesuslcorominas.dxc.data.datasource.net.restclient.impl;

import com.jesuslcorominas.dxc.commons.model.Photo;
import com.jesuslcorominas.dxc.data.datasource.net.dto.PhotosListDto;
import com.jesuslcorominas.dxc.data.datasource.net.restclient.FlickrRestClient;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlickrRestClientImpl implements FlickrRestClient {

    private static final String BASE_URL = "https://www.flickr.com/services/";
    private static final String METHOD_LIST = "flickr.photos.search";
    private static final String FORMAT = "json";
    private static final int NO_JSON_CALLBACK = 1;

    @Inject
    FlickrRestClient.Api api;

    @Inject
    ModelMapper mapper;

    @Override
    public void searchImages(String keywords, String apiKey, String apiSecret, SearchImagesSuccessCallback successCallback, FailureCallback failureCallback) {
        api.searchImages(METHOD_LIST, apiKey, keywords, 1, FORMAT, NO_JSON_CALLBACK).enqueue(new Callback<PhotosListDto>() {

            @Override
            public void onResponse(Call<PhotosListDto> call, Response<PhotosListDto> response) {
                if (!response.isSuccessful()) {
                    failureCallback.onFailure("HTTP Error: " + response.code());
                    return;
                }

                if (response.body() != null) {
                    PhotosListDto photosListDto = response.body();

                    List<Photo> photos = mapper.map(photosListDto.getPhotos(), new TypeToken<List<Photo>>() {
                    }.getType());

                    successCallback.onSuccess(photos);
                    return;

                }

                // No deberiamos llegar nunca hasta aqui
                failureCallback.onFailure("La petición de searchImages no ha devuelto resultados");
            }

            @Override
            public void onFailure(Call<PhotosListDto> call, Throwable throwable) {
                failureCallback.onFailure("Error al obtener la lista de imágenes: " + throwable.getMessage());
            }
        });
    }

    @Override
    public void getImageDetail(String apiKey, String apiSecret, GetImageDetailSuccessCallback successCallback, FailureCallback failureCallback) {

    }
}
