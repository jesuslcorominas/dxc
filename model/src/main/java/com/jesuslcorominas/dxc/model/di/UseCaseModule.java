package com.jesuslcorominas.dxc.model.di;

import com.jesuslcorominas.dxc.model.datasource.FlickrDatasource;
import com.jesuslcorominas.dxc.model.usecase.GetPhotoDetailUseCase;
import com.jesuslcorominas.dxc.model.usecase.SearchPhotosUseCase;
import com.jesuslcorominas.dxc.model.usecase.impl.GetPhotoDetailUseCaseImpl;
import com.jesuslcorominas.dxc.model.usecase.impl.SearchPhotosUseCaseImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class UseCaseModule {

    @Provides
    SearchPhotosUseCase provideSearchPhotosUseCase(FlickrDatasource flickrDatasource) {
        return new SearchPhotosUseCaseImpl(flickrDatasource);
    }

    @Provides
    GetPhotoDetailUseCase provideGetPhotoDetailUseCase(FlickrDatasource flickrDatasource) {
        return new GetPhotoDetailUseCaseImpl(flickrDatasource);
    }
}
