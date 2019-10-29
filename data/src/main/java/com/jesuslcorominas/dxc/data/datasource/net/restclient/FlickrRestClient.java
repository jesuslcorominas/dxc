package com.jesuslcorominas.dxc.data.datasource.net.restclient;

import com.jesuslcorominas.dxc.commons.model.Photo;
import com.jesuslcorominas.dxc.data.datasource.net.dto.SearchResponseDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickrRestClient extends RestClient {

    void searchImages(String keywords, String apiKey, SearchImagesSuccessCallback successCallback, FailureCallback failureCallback);

    void getImageDetail(String apiKey, GetImageDetailSuccessCallback successCallback, FailureCallback failureCallback);

    interface SearchImagesSuccessCallback {
        void onSuccess(List<Photo> photos);
    }

    interface GetImageDetailSuccessCallback {
        void onSuccess();
    }


    interface Api {

        @GET("rest")
        Call<SearchResponseDto> searchImages(@Query("method") String method,
                                             @Query("api_key") String apiKey,
                                             @Query("tags") String tags,
                                             @Query("page") int page,
                                             @Query("format") String format,
                                             @Query("nojsoncallback") int noJSONCallback,
                                             @Query("per_page") int perPage);

        Call<Object> getImageDetail();
    }

}
