package com.jesuslcorominas.dxc.model.usecase;

import com.jesuslcorominas.dxc.commons.model.Photo;

import java.util.List;

public interface SearchImagesUseCase extends UseCase {

    void searchImages(String keywords, String apiKey, String apiSecret, SuccessCallback successCallback, FailureCallback failureCallback);

    interface SuccessCallback {
        void onSuccess(List<Photo> photos);
    }
}
