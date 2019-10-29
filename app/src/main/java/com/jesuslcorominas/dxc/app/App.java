package com.jesuslcorominas.dxc.app;


import androidx.multidex.MultiDexApplication;

import com.jesuslcorominas.dxc.app.di.component.DaggerSearchComponent;
import com.jesuslcorominas.dxc.app.di.component.SearchComponent;
import com.jesuslcorominas.dxc.app.util.Keys;
import com.jesuslcorominas.dxc.data.datasource.di.NetModule;

public class App extends MultiDexApplication {

    private SearchComponent searchComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        searchComponent = DaggerSearchComponent.builder().
                netModule(NetModule.getInstance(Keys.BASE_URL))
                .build();
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }
}
