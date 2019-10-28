package com.jesuslcorominas.dxc.model.usecase;

public interface UseCase {

    interface FailureCallback {
        void onFailure(String message);
    }
}
