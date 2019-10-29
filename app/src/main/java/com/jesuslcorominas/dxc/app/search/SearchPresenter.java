package com.jesuslcorominas.dxc.app.search;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.jesuslcorominas.dxc.app.util.Keys;
import com.jesuslcorominas.dxc.commons.model.Photo;
import com.jesuslcorominas.dxc.model.usecase.GetPhotoDetailUseCase;
import com.jesuslcorominas.dxc.model.usecase.SearchPhotosUseCase;

public class SearchPresenter extends MvpBasePresenter<SearchView> {

    private final SearchPhotosUseCase searchPhotosUseCase;
    private final GetPhotoDetailUseCase getPhotoDetailUseCase;

    public SearchPresenter(SearchPhotosUseCase searchPhotosUseCase, GetPhotoDetailUseCase getPhotoDetailUseCase) {
        this.searchPhotosUseCase = searchPhotosUseCase;
        this.getPhotoDetailUseCase = getPhotoDetailUseCase;
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

        searchPhotosUseCase.searchPhotos(keyword, Keys.API_KEY, photos -> {
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

                    for (Photo p : photos) {
                        getPhotoDetailUseCase.getPhotoDetail(p, Keys.API_KEY, photo -> {
                            ifViewAttached(view1 -> view.refreshItem(photo));
                        }, message -> {

                        });
                    }

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
