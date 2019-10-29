package com.jesuslcorominas.dxc.data.datasource.datasource;

import com.jesuslcorominas.dxc.data.datasource.net.restclient.FlickrRestClient;
import com.jesuslcorominas.dxc.model.datasource.FlickrDatasource;

public class FlickrDatasourceImpl implements FlickrDatasource {

    private final FlickrRestClient flickrRestClient;

    public FlickrDatasourceImpl(FlickrRestClient flickrRestClient) {
        this.flickrRestClient = flickrRestClient;
    }

    @Override
    public void searchImages(String keywords, String apiKey, SearchImagesSuccessCallback successCallback, FailureCallback failureCallback) {
        flickrRestClient.searchImages(keywords, apiKey, successCallback::onSuccess, failureCallback::onFailure);
    }

    @Override
    public void getImageDetail(String apiKey, GetImageDetailSuccessCallback successCallback, FailureCallback failureCallback) {
        flickrRestClient.getImageDetail(apiKey, successCallback::onSuccess, failureCallback::onFailure);
    }
}
