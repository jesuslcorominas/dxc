package com.jesuslcorominas.dxc.model.usecase.impl;

import com.jesuslcorominas.dxc.model.datasource.FlickrDatasource;
import com.jesuslcorominas.dxc.model.usecase.SearchImagesUseCase;

public class SearchImagesUseCaseImpl implements SearchImagesUseCase {

    private final FlickrDatasource flickrDatasource;

    public SearchImagesUseCaseImpl(FlickrDatasource flickrDatasource) {
        this.flickrDatasource = flickrDatasource;
    }

    @Override
    public void searchImages(String keywords, String apiKey, SuccessCallback successCallback, FailureCallback failureCallback) {
        flickrDatasource.searchImages(keywords, apiKey, successCallback::onSuccess, failureCallback::onFailure);
    }
}
