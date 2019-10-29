package com.jesuslcorominas.dxc.app.di.component;

import com.jesuslcorominas.dxc.app.detail.DetailPresenter;
import com.jesuslcorominas.dxc.app.di.module.DetailModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DetailModule.class})
public interface DetailComponent {

    DetailPresenter getDetailPresenter();
}
