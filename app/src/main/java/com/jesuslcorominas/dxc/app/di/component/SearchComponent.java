package com.jesuslcorominas.dxc.app.di.component;

import com.jesuslcorominas.dxc.app.di.module.SearchModule;
import com.jesuslcorominas.dxc.app.search.SearchPresenter;
import com.jesuslcorominas.dxc.data.datasource.di.DatasourceModule;
import com.jesuslcorominas.dxc.model.di.UseCaseModule;
import com.jesuslcorominas.dxc.model.usecase.SearchImagesUseCase;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {SearchModule.class})
public interface SearchComponent {

    SearchPresenter getSearchPresenter();

}
