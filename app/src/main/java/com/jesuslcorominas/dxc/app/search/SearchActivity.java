package com.jesuslcorominas.dxc.app.search;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jesuslcorominas.dxc.app.R;
import com.jesuslcorominas.dxc.commons.model.Photo;

public class SearchActivity extends AppCompatActivity implements SearchFragment.SearchFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_search_frameLayout_content, SearchFragment.newInstance())
                .commit();
    }

    // region SearchFragment.SearchFragmentInteractionListener

    @Override
    public void onPhotoClick(Photo photo) {
        // TODO navegar a la pantalla de detalle
    }

    //endregion
}
