package com.jesuslcorominas.dxc.model.di;

import com.jesuslcorominas.dxc.model.datasource.FlickrDatasource;
import com.jesuslcorominas.dxc.model.usecase.GetImageDetailUseCase;
import com.jesuslcorominas.dxc.model.usecase.SearchImagesUseCase;
import com.jesuslcorominas.dxc.model.usecase.impl.GetImageDetailUseCaseImpl;
import com.jesuslcorominas.dxc.model.usecase.impl.SearchImagesUseCaseImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class UseCaseModule {

    @Provides
    SearchImagesUseCase provideSearchImagesUseCase(FlickrDatasource flickrDatasource) {
        return new SearchImagesUseCaseImpl(flickrDatasource);
    }

    @Provides
    GetImageDetailUseCase provideGetImageDetailUseCase() {
        return new GetImageDetailUseCaseImpl();
    }
}
