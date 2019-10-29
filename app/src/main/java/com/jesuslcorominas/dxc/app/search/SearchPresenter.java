package com.jesuslcorominas.dxc.app.search;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.jesuslcorominas.dxc.app.util.Keys;
import com.jesuslcorominas.dxc.model.usecase.SearchImagesUseCase;

public class SearchPresenter extends MvpBasePresenter<SearchView> {

    private final SearchImagesUseCase searchImagesUseCase;

    public SearchPresenter(SearchImagesUseCase searchImagesUseCase) {
        this.searchImagesUseCase = searchImagesUseCase;
    }

    public void searchImages(String keyword) {
        if (keyword == null || keyword.trim().length() == 0) {
            // TODO mostrar error?
            return;
        }

        searchImagesUseCase.searchImages(keyword, Keys.API_KEY, photos -> {
            // TODO mostrar imagenes
        }, message -> {
            // TODO mostrar error
        });
    }
}
