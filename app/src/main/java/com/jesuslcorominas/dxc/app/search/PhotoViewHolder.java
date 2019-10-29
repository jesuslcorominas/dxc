package com.jesuslcorominas.dxc.app.search;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jesuslcorominas.dxc.app.R;
import com.jesuslcorominas.dxc.commons.model.Photo;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_photo_imageView_thumb)
    ImageView imageViewThumb;

    @BindView(R.id.item_photo_textView_title)
    TextView textViewTitle;

    @BindView(R.id.item_photo_textView_author)
    TextView textViewAuthor;

    public PhotoViewHolder(@NonNull View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public void bind(Photo photo) {
        Picasso.get().load(photo.getThumbnail()).into(imageViewThumb);

        textViewTitle.setText(photo.getTitle());
        textViewAuthor.setText(photo.getOwner());
    }
}
