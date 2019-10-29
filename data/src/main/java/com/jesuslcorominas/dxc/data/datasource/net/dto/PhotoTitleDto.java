package com.jesuslcorominas.dxc.data.datasource.net.dto;

import com.google.gson.annotations.SerializedName;

public class PhotoTitleDto {

    @SerializedName("_content")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
