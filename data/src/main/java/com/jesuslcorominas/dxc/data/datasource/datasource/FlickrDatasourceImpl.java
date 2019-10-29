package com.jesuslcorominas.dxc.data.datasource.datasource;

import com.jesuslcorominas.dxc.commons.model.Photo;
import com.jesuslcorominas.dxc.data.datasource.net.restclient.FlickrRestClient;
import com.jesuslcorominas.dxc.model.datasource.FlickrDatasource;

public class FlickrDatasourceImpl implements FlickrDatasource {

    private final FlickrRestClient flickrRestClient;

    public FlickrDatasourceImpl(FlickrRestClient flickrRestClient) {
        this.flickrRestClient = flickrRestClient;
    }

    @Override
    public void searchPhotos(String keywords, String apiKey, SearchPhotosSuccessCallback successCallback, FailureCallback failureCallback) {
        flickrRestClient.searchPhotos(keywords, apiKey, successCallback::onSuccess, failureCallback::onFailure);
    }

    @Override
    public void getPhotoDetail(Photo photo, String apiKey, GetPhotoDetailSuccessCallback successCallback, FailureCallback failureCallback) {
        flickrRestClient.getPhotoDetail(photo, apiKey, successCallback::onSuccess, failureCallback::onFailure);
    }
}
