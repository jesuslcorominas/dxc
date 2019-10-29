package com.jesuslcorominas.dxc.data.datasource.net.dto;

import com.google.gson.annotations.SerializedName;

public class PhotoDetailDto {

    private String id;

    @SerializedName("title")
    private PhotoTitleDto photoTitle;

    @SerializedName("owner")
    private PhotoOwnerDto photoOwner;

    @SerializedName("dates")
    private PhotoDatesDto photoDates;

    private String secret;
    private String server;
    private int farm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PhotoTitleDto getPhotoTitle() {
        return photoTitle;
    }

    public void setPhotoTitle(PhotoTitleDto photoTitle) {
        this.photoTitle = photoTitle;
    }

    public PhotoOwnerDto getPhotoOwner() {
        return photoOwner;
    }

    public void setPhotoOwner(PhotoOwnerDto photoOwner) {
        this.photoOwner = photoOwner;
    }

    public PhotoDatesDto getPhotoDates() {
        return photoDates;
    }

    public void setPhotoDates(PhotoDatesDto photoDates) {
        this.photoDates = photoDates;
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
}
