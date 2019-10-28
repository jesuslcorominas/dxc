package com.jesuslcorominas.dxc.data.datasource.di;

import org.modelmapper.ModelMapper;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module
public class MapperModule {

    @Provides
    ModelMapper provideModelMapper() {
        return new ModelMapper();
    }


}
