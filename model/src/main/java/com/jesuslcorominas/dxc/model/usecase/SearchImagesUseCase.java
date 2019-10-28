package com.jesuslcorominas.dxc.model.usecase;

public interface SearchImagesUseCase extends UseCase {

    void searchImages(String keywords, String apiKey, String apiSecret, SuccessCallback successCallback, FailureCallback failureCallback);

    interface SuccessCallback {
        void onSuccess();
    }
}
