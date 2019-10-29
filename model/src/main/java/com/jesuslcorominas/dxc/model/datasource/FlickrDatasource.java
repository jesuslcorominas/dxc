package com.jesuslcorominas.dxc.model.datasource;

import com.jesuslcorominas.dxc.commons.model.Photo;

import java.util.List;

public interface FlickrDatasource extends Datasource {

    void searchImages(String keywords, String apiKey, SearchImagesSuccessCallback successCallback, FailureCallback failureCallback);

    void getImageDetail(String apiKey, GetImageDetailSuccessCallback successCallback, FailureCallback failureCallback);

    interface SearchImagesSuccessCallback {
        void onSuccess(List<Photo> photos);
    }

    interface GetImageDetailSuccessCallback {
        void onSuccess();
    }
}
