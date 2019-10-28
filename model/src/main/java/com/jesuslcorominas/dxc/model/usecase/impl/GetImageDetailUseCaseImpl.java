package com.jesuslcorominas.dxc.model.usecase.impl;

import com.jesuslcorominas.dxc.model.datasource.FlickrDatasource;
import com.jesuslcorominas.dxc.model.usecase.GetImageDetailUseCase;

public class GetImageDetailUseCaseImpl implements GetImageDetailUseCase {

    FlickrDatasource flickrDatasource;

    @Override
    public void getImageDetail(String apiKey, String apiSecret, SuccessCallback successCallback, FailureCallback failureCallback) {
        flickrDatasource.getImageDetail(apiKey, apiSecret, successCallback::onSuccess, failureCallback::onFailure);
    }
}
