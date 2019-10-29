package com.jesuslcorominas.dxc.commons.model;

import java.util.Locale;

public class Photo {

    private static final String IMAGE_URL = "https://farm%d.staticflickr.com/%s/%s_%s_%s.jpg";
    private static final String SMALL = "s";
    private static final String BIG = "b";

    private String id;
    private String owner;
    private String title;
    private String secret;
    private String server;
    private int farm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

}
