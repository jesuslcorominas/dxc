package com.jesuslcorominas.dxc.model.usecase.impl;

import com.jesuslcorominas.dxc.model.datasource.FlickrDatasource;
import com.jesuslcorominas.dxc.model.usecase.SearchPhotosUseCase;

public class SearchPhotosUseCaseImpl implements SearchPhotosUseCase {

    private final FlickrDatasource flickrDatasource;

    public SearchPhotosUseCaseImpl(FlickrDatasource flickrDatasource) {
        this.flickrDatasource = flickrDatasource;
    }

    @Override
    public void searchPhotos(String keywords, String apiKey, SuccessCallback successCallback, FailureCallback failureCallback) {
        flickrDatasource.searchPhotos(keywords, apiKey, successCallback::onSuccess, failureCallback::onFailure);
    }
}
