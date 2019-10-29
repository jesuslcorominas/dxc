package com.jesuslcorominas.dxc.app.di.module;

import com.jesuslcorominas.dxc.app.search.SearchPresenter;
import com.jesuslcorominas.dxc.data.datasource.di.DatasourceModule;
import com.jesuslcorominas.dxc.model.di.UseCaseModule;
import com.jesuslcorominas.dxc.model.usecase.GetPhotoDetailUseCase;
import com.jesuslcorominas.dxc.model.usecase.SearchPhotosUseCase;

import dagger.Module;
import dagger.Provides;

@Module(includes = {UseCaseModule.class, DatasourceModule.class})
public class SearchModule {

    @Provides
    SearchPresenter provideSearchPresenter(SearchPhotosUseCase searchPhotosUseCase, GetPhotoDetailUseCase getPhotoDetailUseCase) {
        return new SearchPresenter(searchPhotosUseCase, getPhotoDetailUseCase);
    }
}
