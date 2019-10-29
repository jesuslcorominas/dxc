package com.jesuslcorominas.dxc.model.usecase;

public interface GetImageDetailUseCase extends UseCase {

    void getImageDetail(String apiKey, SuccessCallback successCallback, FailureCallback failureCallback);

    interface SuccessCallback {
        void onSuccess();
    }
}
