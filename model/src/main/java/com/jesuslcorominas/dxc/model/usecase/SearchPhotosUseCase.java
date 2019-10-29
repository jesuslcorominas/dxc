package com.jesuslcorominas.dxc.model.usecase;

import com.jesuslcorominas.dxc.commons.model.Photo;

import java.util.List;

public interface SearchPhotosUseCase extends UseCase {

    void searchPhotos(String keywords, String apiKey, SuccessCallback successCallback, FailureCallback failureCallback);

    interface SuccessCallback {
        void onSuccess(List<Photo> photos);
    }
}
