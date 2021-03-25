package dev.pinter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchImage {
    @JsonProperty("height")
    private int height;

    @JsonProperty("width")
    private int width;

    @JsonProperty("url")
    private String url;


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "SearchImage{" +
                "height=" + height +
                ", width=" + width +
                ", url='" + url + "\n" +
                '}';
    }
}
