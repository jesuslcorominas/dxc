package com.jesuslcorominas.dxc.data.datasource.di;

import com.jesuslcorominas.dxc.data.datasource.datasource.FlickrDatasourceImpl;
import com.jesuslcorominas.dxc.model.datasource.FlickrDatasource;

import dagger.Module;
import dagger.Provides;

@Module
public class DatasourceModule {

    @Provides
    FlickrDatasource provideFlickrDatasource() {
        return new FlickrDatasourceImpl();
    }
}
