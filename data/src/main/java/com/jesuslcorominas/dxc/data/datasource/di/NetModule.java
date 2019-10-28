package com.jesuslcorominas.dxc.data.datasource.di;

import com.google.gson.Gson;
import com.jesuslcorominas.dxc.data.datasource.net.restclient.FlickrRestClient;
import com.jesuslcorominas.dxc.data.datasource.net.restclient.impl.FlickrRestClientImpl;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
@Module(includes = {GsonModule.class, MapperModule.class})
public class NetModule {

    private static final int READ_TIMEOUT = 10;
    private static final int CONNECT_TIMEOUT = 3;

    private static NetModule instance;

    private String endPoint;

    private NetModule(String endPoint) {
        this.endPoint = endPoint;
    }

    public static NetModule getInstance(String endPoint) {
        if (instance == null) {
            instance = new NetModule(endPoint);
        }

        return instance;
    }

    @Singleton
    @Provides
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);

        return interceptor;
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor) {
        return new OkHttpClient.Builder().
                readTimeout(READ_TIMEOUT, TimeUnit.SECONDS).
                connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS).
                addInterceptor(loggingInterceptor).
                build();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder().
                baseUrl(endPoint).
                addConverterFactory(GsonConverterFactory.create(gson)).
                client(okHttpClient).
                build();
    }

    @Provides
    FlickrRestClient.Api provideFlickrRestClientApi(Retrofit retrofit) {
        return retrofit.create(FlickrRestClient.Api.class);
    }

    @Provides
    FlickrRestClient provideFlickrRestClient() {
        return new FlickrRestClientImpl();
    }

}
