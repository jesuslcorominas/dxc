package com.jesuslcorominas.dxc.data.datasource.datasource;

import com.jesuslcorominas.dxc.data.datasource.net.restclient.FlickrRestClient;
import com.jesuslcorominas.dxc.model.datasource.FlickrDatasource;

import javax.inject.Inject;

public class FlickrDatasourceImpl implements FlickrDatasource {

    @Inject
    FlickrRestClient flickrRestClient;

    @Override
    public void searchImages(String keywords, String apiKey, String apiSecret, SearchImagesSuccessCallback successCallback, FailureCallback failureCallback) {
        flickrRestClient.searchImages(keywords, apiKey, apiSecret, successCallback::onSuccess, failureCallback::onFailure);
    }

    @Override
    public void getImageDetail(String apiKey, String apiSecret, GetImageDetailSuccessCallback successCallback, FailureCallback failureCallback) {
        flickrRestClient.getImageDetail(apiKey, apiSecret, successCallback::onSuccess, failureCallback::onFailure);
    }
}
