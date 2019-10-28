package com.jesuslcorominas.dxc.model.datasource;

public interface FlickrDatasource extends Datasource {

    void searchImages(String keywords, String apiKey, String apiSecret, SearchImagesSuccessCallback successCallback, FailureCallback failureCallback);

    void getImageDetail(String apiKey, String apiSecret, GetImageDetailSuccessCallback successCallback, FailureCallback failureCallback);

    interface SearchImagesSuccessCallback {
        void onSuccess();
    }

    interface GetImageDetailSuccessCallback {
        void onSuccess();
    }
}
