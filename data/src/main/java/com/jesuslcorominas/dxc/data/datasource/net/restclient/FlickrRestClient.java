package com.jesuslcorominas.dxc.data.datasource.net.restclient;

import com.jesuslcorominas.dxc.commons.model.Photo;
import com.jesuslcorominas.dxc.data.datasource.net.dto.GetPhotoDetailResponseDto;
import com.jesuslcorominas.dxc.data.datasource.net.dto.SearchResponseDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickrRestClient extends RestClient {

    void searchPhotos(String keywords, String apiKey, SearchPhotosSuccessCallback successCallback, FailureCallback failureCallback);

    void getPhotoDetail(Photo photo, String apiKey, GetPhotoDetailSuccessCallback successCallback, FailureCallback failureCallback);

    interface SearchPhotosSuccessCallback {
        void onSuccess(List<Photo> photos);
    }

    interface GetPhotoDetailSuccessCallback {
        void onSuccess(Photo photo);
    }


    interface Api {

        @GET("rest")
        Call<SearchResponseDto> searchPhotos(@Query("method") String method,
                                             @Query("api_key") String apiKey,
                                             @Query("tags") String tags,
                                             @Query("page") int page,
                                             @Query("format") String format,
                                             @Query("nojsoncallback") int noJSONCallback,
                                             @Query("per_page") int perPage);

        @GET("rest")
        Call<GetPhotoDetailResponseDto> getPhotoDetail(@Query("method") String method,
                                                           @Query("api_key") String apiKey,
                                                           @Query("photo_id") String photoId,
                                                           @Query("secret") String secret,
                                                           @Query("format") String format,
                                                           @Query("nojsoncallback") int noJSONCallback);
    }

}
