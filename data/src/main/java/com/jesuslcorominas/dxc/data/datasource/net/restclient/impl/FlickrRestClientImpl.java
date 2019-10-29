package com.jesuslcorominas.dxc.data.datasource.net.restclient.impl;

import com.jesuslcorominas.dxc.commons.model.Photo;
import com.jesuslcorominas.dxc.data.datasource.net.dto.PhotosListDto;
import com.jesuslcorominas.dxc.data.datasource.net.dto.SearchResponseDto;
import com.jesuslcorominas.dxc.data.datasource.net.restclient.FlickrRestClient;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlickrRestClientImpl implements FlickrRestClient {


    private static final String METHOD_LIST = "flickr.photos.search";
    private static final String FORMAT = "json";
    private static final int NO_JSON_CALLBACK = 1;
    private static final int PER_PAGE = 25;

    private final FlickrRestClient.Api api;

    private final ModelMapper mapper;

    @Inject
    public FlickrRestClientImpl(FlickrRestClient.Api api, ModelMapper mapper) {
        this.api = api;
        this.mapper = mapper;
    }

    @Override
    public void searchImages(String keywords, String apiKey, SearchImagesSuccessCallback successCallback, FailureCallback failureCallback) {
        api.searchImages(METHOD_LIST, apiKey, keywords, 1, FORMAT, NO_JSON_CALLBACK, PER_PAGE).enqueue(new Callback<SearchResponseDto>() {

            @Override
            public void onResponse(Call<SearchResponseDto> call, Response<SearchResponseDto> response) {
                if (!response.isSuccessful()) {
                    failureCallback.onFailure("HTTP Error: " + response.code());
                    return;
                }

                if (response.body() != null) {
                    SearchResponseDto searchResponseDto = response.body();
                    PhotosListDto photosListDto = searchResponseDto.getPhotosListDto();

                    List<Photo> photos = mapper.map(photosListDto.getPhotos(), new TypeToken<List<Photo>>() {
                    }.getType());

                    successCallback.onSuccess(photos);
                    return;

                }

                // No deberiamos llegar nunca hasta aqui
                failureCallback.onFailure("La petición de searchImages no ha devuelto resultados");
            }

            @Override
            public void onFailure(Call<SearchResponseDto> call, Throwable throwable) {
                failureCallback.onFailure(throwable.getMessage());
            }
        });
    }

    @Override
    public void getImageDetail(String apiKey, GetImageDetailSuccessCallback successCallback, FailureCallback failureCallback) {

    }
}
