package com.jesuslcorominas.dxc.app.detail;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.jesuslcorominas.dxc.app.App;
import com.jesuslcorominas.dxc.app.R;
import com.jesuslcorominas.dxc.app.util.Keys;
import com.jesuslcorominas.dxc.commons.model.Photo;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailFragment extends MvpFragment<DetailView, DetailPresenter> implements DetailView {


    @BindView(R.id.fragment_detail_imageView_photo)
    ImageView imageViewPhoto;

    @BindView(R.id.fragment_detail_textView_title)
    TextView textViewTitle;

    @BindView(R.id.fragment_detail_textView_author)
    TextView textViewAuthor;

    @BindView(R.id.fragment_detail_textView_date)
    TextView textViewDate;

    @BindView(R.id.fragment_detail_textView_description)
    TextView textViewDescription;

    private DetailFragmentInteractionListener listener;

    private Photo photo;

    static DetailFragment newInstance(Photo photo) {
        Bundle arguments = new Bundle();
        arguments.putSerializable(Keys.PHOTO_EXTRA, photo);

        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(arguments);

        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        listener = (DetailFragmentInteractionListener) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();

        listener = null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable(Keys.PHOTO_EXTRA);
            if (serializable != null) {
                photo = (Photo) serializable;
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.get().load(photo.getPhoto()).into(imageViewPhoto);

        textViewTitle.setText(photo.getPhotoTitle().getContent());
        textViewAuthor.setText(photo.getPhotoOwner().getUsername());
        textViewDate.setText(photo.getPhotoDates().getTaken());

        textViewDescription.setText(Html.fromHtml(photo.getPhotoDescription().getContent()));

        return view;
    }


    @Override
    @NonNull
    public DetailPresenter createPresenter() {
        return ((App) (Objects.requireNonNull(getActivity()).getApplication())).getDetailComponent().getDetailPresenter();
    }


    public interface DetailFragmentInteractionListener {

    }
}
