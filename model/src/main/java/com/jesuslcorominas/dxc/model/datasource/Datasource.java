package com.jesuslcorominas.dxc.model.datasource;

public interface Datasource {

    interface FailureCallback {
        void onFailure(String message);
    }
}
