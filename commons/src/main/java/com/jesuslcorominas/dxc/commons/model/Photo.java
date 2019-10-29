package com.jesuslcorominas.dxc.commons.model;

import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;

public class Photo implements Serializable {

    private static final String IMAGE_URL = "https://farm%d.staticflickr.com/%s/%s_%s_%s.jpg";
    private static final String SMALL = "s";
    private static final String BIG = "b";

    private String id;

    private PhotoOwner photoOwner;
    private PhotoDates photoDates;
    private PhotoTitle photoTitle;
    private PhotoDescription photoDescription;

    private String secret;
    private String server;
    private int farm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PhotoOwner getPhotoOwner() {
        return photoOwner;
    }

    public void setPhotoOwner(PhotoOwner photoOwner) {
        this.photoOwner = photoOwner;
    }

    public PhotoDates getPhotoDates() {
        return photoDates;
    }

    public void setPhotoDates(PhotoDates photoDates) {
        this.photoDates = photoDates;
    }

    public PhotoTitle getPhotoTitle() {
        return photoTitle;
    }

    public void setPhotoTitle(PhotoTitle photoTitle) {
        this.photoTitle = photoTitle;
    }

    public PhotoDescription getPhotoDescription() {
        return photoDescription;
    }

    public void setPhotoDescription(PhotoDescription photoDescription) {
        this.photoDescription = photoDescription;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getFarm() {
        return farm;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }

    public String getThumbnail() {
        return formatImageUrl(SMALL);
    }

    public String getPhoto() {
        return formatImageUrl(BIG);
    }

    private String formatImageUrl(String size) {
        return String.format(Locale.getDefault(), IMAGE_URL, farm, server, id, secret, size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Photo)) return false;
        Photo photo = (Photo) o;
        return getId().equals(photo.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
