package dev.pinter;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SearchItem extends Album{
    @JsonProperty("external_urls")
    private SearchExternalUrl externalUrl;

    @JsonProperty("followers")
    private SearchFollowers followers;

    private String strGenres;

    @JsonProperty("images")
    private List<SearchImage> images;

    @JsonProperty("type")
    private String type;

    @JsonProperty("popularity")
    private int popularity;

    @JsonProperty("uri")
    private String uri;


    public SearchExternalUrl getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(SearchExternalUrl externalUrl) {
        this.externalUrl = externalUrl;
    }

    public SearchFollowers getFollowers() {
        return followers;
    }

    public void setFollowers(SearchFollowers followers) {
        this.followers = followers;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<SearchImage> getImages() {
        return images;
    }

    public void setImages(List<SearchImage> images) {
        this.images = images;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getStrGenres() {
        return strGenres;
    }

    public void setStrGenres(String strGenres) {
        this.strGenres = strGenres;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "SearchItem{" +
                "externalUrl=" + externalUrl + "\n" +
                " followers=" + followers + "\n" +
                " images=" + images + "\n" +
                " type='" + type + "\n" +
                " popularity=" + popularity + "\n" +
                " uri='" + uri + "\n" +
                "}\n\n\n\n";
    }
}
