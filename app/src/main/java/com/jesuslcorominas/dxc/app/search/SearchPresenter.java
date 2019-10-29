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
        ifViewAttached(view -> {
            view.clearResults();
            view.hideNoResults();
            view.showLoading();
        });

        if (keyword == null || keyword.trim().length() == 0) {
            ifViewAttached(view -> {
                view.hideResults();
                view.hideLoading();
                view.showNoResults();
            });
            return;
        }

        searchImagesUseCase.searchImages(keyword, Keys.API_KEY, photos -> {
            ifViewAttached(view -> {
                view.hideLoading();
                view.hideError();

                if (photos == null || photos.size() == 0) {
                    view.showNoResults();
                    view.hideResults();
                } else {
                    view.addResults(photos);
                    view.showResults();

                    view.hideNoResults();
                }
            });
        }, message -> {
            ifViewAttached(view -> {
                view.hideNoResults();
                view.hideLoading();
                view.hideResults();

                view.showError(message);
            });
        });
    }
}
