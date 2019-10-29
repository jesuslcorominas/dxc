package com.jesuslcorominas.dxc.model.usecase.impl;

import com.jesuslcorominas.dxc.commons.model.Photo;
import com.jesuslcorominas.dxc.model.datasource.FlickrDatasource;
import com.jesuslcorominas.dxc.model.usecase.GetPhotoDetailUseCase;

public class GetPhotoDetailUseCaseImpl implements GetPhotoDetailUseCase {

    private final FlickrDatasource flickrDatasource;

    public GetPhotoDetailUseCaseImpl(FlickrDatasource flickrDatasource) {
        this.flickrDatasource = flickrDatasource;
    }

    @Override
    public void getPhotoDetail(Photo photo, String apiKey, SuccessCallback successCallback, FailureCallback failureCallback) {
        flickrDatasource.getPhotoDetail(photo, apiKey, successCallback::onSuccess, failureCallback::onFailure);
    }
}
