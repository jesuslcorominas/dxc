package com.jesuslcorominas.dxc.app.detail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jesuslcorominas.dxc.app.R;
import com.jesuslcorominas.dxc.app.util.Keys;
import com.jesuslcorominas.dxc.commons.model.Photo;

import java.io.Serializable;

public class DetailActivity extends AppCompatActivity implements DetailFragment.DetailFragmentInteractionListener {

    public static void start(Activity activity, Photo photo) {
        Intent i = new Intent(activity, DetailActivity.class);
        i.putExtra(Keys.PHOTO_EXTRA, photo);

        activity.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                Serializable p = extras.getSerializable(Keys.PHOTO_EXTRA);
                if (p != null) {
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.activity_detail_frameLayout_content, DetailFragment.newInstance((Photo) p))
                            .commit();
                    return;
                }
            }
        }

        // Si llegamos aqui es que no pasamos bien la foto
        finish();
    }
}
