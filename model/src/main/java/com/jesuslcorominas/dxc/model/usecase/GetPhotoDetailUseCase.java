package com.jesuslcorominas.dxc.model.usecase;

import com.jesuslcorominas.dxc.commons.model.Photo;

public interface GetPhotoDetailUseCase extends UseCase {

    void getPhotoDetail(Photo photo, String apiKey, SuccessCallback successCallback, FailureCallback failureCallback);

    interface SuccessCallback {
        void onSuccess(Photo photo);
    }
}
