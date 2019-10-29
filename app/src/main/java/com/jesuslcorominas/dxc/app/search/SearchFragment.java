package com.jesuslcorominas.dxc.app.search;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.jesuslcorominas.dxc.app.App;
import com.jesuslcorominas.dxc.app.R;
import com.jesuslcorominas.dxc.commons.model.Photo;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchFragment extends MvpFragment<SearchView, SearchPresenter> {

    @BindView(R.id.fragment_search_editText_search)
    EditText editTextSearch;

    @BindView(R.id.fragment_search_imageButton_search)
    ImageButton imageButtonSearch;

    private SearchFragmentInteractionListener listener;

    static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        listener = (SearchFragmentInteractionListener) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();

        listener = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, view);

        imageButtonSearch.setOnClickListener(v -> presenter.searchImages(editTextSearch.getText().toString()));

        return view;
    }

    @Override
    @NonNull
    public SearchPresenter createPresenter() {
        return ((App) (Objects.requireNonNull(getActivity()).getApplication())).getSearchComponent().getSearchPresenter();
    }

    public interface SearchFragmentInteractionListener {
        void onPhotoClick(Photo photo);
    }
}
