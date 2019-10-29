package com.jesuslcorominas.dxc.app.search;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.jesuslcorominas.dxc.app.App;
import com.jesuslcorominas.dxc.app.R;
import com.jesuslcorominas.dxc.commons.model.Photo;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchFragment extends MvpFragment<SearchView, SearchPresenter> implements SearchView {

    // region View
    @BindView(R.id.fragment_search_editText_search)
    EditText editTextSearch;

    @BindView(R.id.fragment_search_imageButton_search)
    ImageButton imageButtonSearch;

    @BindView(R.id.fragment_search_linearLayout_noResults)
    LinearLayout linearLayoutNoResults;

    @BindView(R.id.fragment_search_linearLayout_loading)
    LinearLayout linearLayoutLoading;

    @BindView(R.id.fragment_search_recyclerView_results)
    RecyclerView recyclerViewResults;

    @BindView(R.id.fragment_search_linearLayout_error)
    LinearLayout linearLayoutError;

    @BindView(R.id.fragment_search_textView_error)
    TextView textViewError;
    // endregion

    private SearchFragmentInteractionListener listener;

    private PhotosAdapter photosAdapter;

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

        editTextSearch.setOnEditorActionListener((v, actionId, event) -> {
            boolean handled = false;

            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                performSearch();

                handled = true;
            }
            return handled;
        });

        imageButtonSearch.setOnClickListener(v -> performSearch());

        photosAdapter = new PhotosAdapter(this);

        recyclerViewResults.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewResults.setAdapter(photosAdapter);
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(recyclerViewResults.getContext(), DividerItemDecoration.VERTICAL);
        recyclerViewResults.addItemDecoration(dividerItemDecoration);

        return view;
    }

    @Override
    @NonNull
    public SearchPresenter createPresenter() {
        return ((App) (Objects.requireNonNull(getActivity()).getApplication())).getSearchComponent().getSearchPresenter();
    }

    // region SearchView

    @Override
    public void showNoResults() {
        linearLayoutNoResults.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideNoResults() {
        linearLayoutNoResults.setVisibility(View.GONE);
    }

    @Override
    public void hideResults() {
        recyclerViewResults.setVisibility(View.GONE);
    }

    @Override
    public void showResults() {
        recyclerViewResults.setVisibility(View.VISIBLE);
    }

    @Override
    public void addResults(List<Photo> photos) {
        photosAdapter.addItems(photos);
    }

    @Override
    public void showLoading() {
        linearLayoutLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        linearLayoutLoading.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        textViewError.setText(message);
        linearLayoutError.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideError() {
        linearLayoutError.setVisibility(View.GONE);
    }

    @Override
    public void clearResults() {
        photosAdapter.clear();
    }

    @Override
    public void refreshItem(Photo photo) {
        photosAdapter.refreshItem(photo);
    }

    @Override
    public void onItemClick(Photo photo) {
        Objects.requireNonNull(listener).onPhotoClick(photo);
    }

    // endregion

    public interface SearchFragmentInteractionListener {
        void onPhotoClick(Photo photo);
    }

    private void performSearch() {
        InputMethodManager imm = (InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editTextSearch.getWindowToken(), 0);

        presenter.searchImages(editTextSearch.getText().toString());
    }
}
