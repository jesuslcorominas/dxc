package com.jesuslcorominas.dxc.data.datasource.net.restclient;

public interface RestClient {

    interface FailureCallback {
        void onFailure(String message);
    }
}
