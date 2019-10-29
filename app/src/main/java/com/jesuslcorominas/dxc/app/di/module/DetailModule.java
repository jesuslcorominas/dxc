package com.jesuslcorominas.dxc.app.di.module;

import com.jesuslcorominas.dxc.app.detail.DetailPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailModule {

    @Provides
    DetailPresenter provideDetailPresenter() {
        return new DetailPresenter();
    }
}
