package com.jesuslcorominas.dxc.model.datasource;

import com.jesuslcorominas.dxc.commons.model.Photo;

import java.util.List;

public interface FlickrDatasource extends Datasource {

    void searchPhotos(String keywords, String apiKey, SearchPhotosSuccessCallback successCallback, FailureCallback failureCallback);

    void getPhotoDetail(Photo photo, String apiKey, GetPhotoDetailSuccessCallback successCallback, FailureCallback failureCallback);

    interface SearchPhotosSuccessCallback {
        void onSuccess(List<Photo> photos);
    }

    interface GetPhotoDetailSuccessCallback {
        void onSuccess(Photo photo);
    }
}
