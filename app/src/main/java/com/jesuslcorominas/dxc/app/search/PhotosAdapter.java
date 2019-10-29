package com.jesuslcorominas.dxc.app.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jesuslcorominas.dxc.app.R;
import com.jesuslcorominas.dxc.commons.model.Photo;

import java.util.ArrayList;
import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotoViewHolder> {

    private List<Photo> items;

    public PhotosAdapter() {
        items = new ArrayList<>();
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItems(List<Photo> photos) {
        int from = items.size();
        items.addAll(photos);

        notifyItemRangeChanged(from, photos.size());
    }

    public void refreshItem(Photo photo) {
        int position = items.indexOf(photo);

        items.set(position, photo);

        notifyItemChanged(position);
    }

    public void clear() {
        if (items == null || items.size() <= 0) {
            return;
        }

        final int size = items.size();
        items.clear();
        notifyItemRangeRemoved(0, size);
    }
}
