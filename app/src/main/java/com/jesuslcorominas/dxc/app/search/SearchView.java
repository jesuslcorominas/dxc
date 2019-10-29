package com.jesuslcorominas.dxc.app.search;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.jesuslcorominas.dxc.commons.model.Photo;

import java.util.List;

public interface SearchView extends MvpView {

    void showNoResults();

    void hideNoResults();

    void hideResults();

    void showResults();

    void addResults(List<Photo> photos);

    void showLoading();

    void hideLoading();

    void showError(String message);

    void hideError();

    void clearResults();

    void refreshItem(Photo photo);
}
