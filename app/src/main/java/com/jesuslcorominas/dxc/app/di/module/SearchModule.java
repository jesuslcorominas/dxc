package com.jesuslcorominas.dxc.app.di.module;

import com.jesuslcorominas.dxc.app.search.SearchPresenter;
import com.jesuslcorominas.dxc.data.datasource.di.DatasourceModule;
import com.jesuslcorominas.dxc.model.di.UseCaseModule;
import com.jesuslcorominas.dxc.model.usecase.SearchImagesUseCase;

import dagger.Module;
import dagger.Provides;

@Module(includes = {UseCaseModule.class, DatasourceModule.class})
public class SearchModule {

    @Provides
    SearchPresenter provideSearchPresenter(SearchImagesUseCase searchImagesUseCase) {
        return new SearchPresenter(searchImagesUseCase);
    }
}
