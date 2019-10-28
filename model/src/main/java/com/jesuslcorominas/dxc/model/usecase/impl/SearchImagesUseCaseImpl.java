package com.jesuslcorominas.dxc.model.usecase.impl;

import com.jesuslcorominas.dxc.model.datasource.FlickrDatasource;
import com.jesuslcorominas.dxc.model.usecase.SearchImagesUseCase;

import javax.inject.Inject;

public class SearchImagesUseCaseImpl implements SearchImagesUseCase {

    @Inject
    FlickrDatasource flickrDatasource;

    @Override
    public void searchImages(String keywords, String apiKey, String apiSecret, SuccessCallback successCallback, FailureCallback failureCallback) {
        flickrDatasource.searchImages(keywords, apiKey, apiSecret, successCallback::onSuccess, failureCallback::onFailure);
    }
}
