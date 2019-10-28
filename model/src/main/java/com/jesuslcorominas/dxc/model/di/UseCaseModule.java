package com.jesuslcorominas.dxc.model.di;

import com.jesuslcorominas.dxc.model.usecase.GetImageDetailUseCase;
import com.jesuslcorominas.dxc.model.usecase.SearchImagesUseCase;
import com.jesuslcorominas.dxc.model.usecase.impl.GetImageDetailUseCaseImpl;
import com.jesuslcorominas.dxc.model.usecase.impl.SearchImagesUseCaseImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class UseCaseModule {

    @Provides
    SearchImagesUseCase provideSearchImagesUseCase() {
        return new SearchImagesUseCaseImpl();
    }

    @Provides
    GetImageDetailUseCase provideGetImageDetailUseCase() {
        return new GetImageDetailUseCaseImpl();
    }
}
