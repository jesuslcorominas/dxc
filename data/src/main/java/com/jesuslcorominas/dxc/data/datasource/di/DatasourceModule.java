package com.jesuslcorominas.dxc.data.datasource.di;

import com.jesuslcorominas.dxc.data.datasource.datasource.FlickrDatasourceImpl;
import com.jesuslcorominas.dxc.data.datasource.net.restclient.FlickrRestClient;
import com.jesuslcorominas.dxc.model.datasource.FlickrDatasource;

import dagger.Module;
import dagger.Provides;

@Module(includes = NetModule.class)
public class DatasourceModule {

    @Provides
    FlickrDatasource provideFlickrDatasource(FlickrRestClient flickrRestClient) {
        return new FlickrDatasourceImpl(flickrRestClient);
    }
}
