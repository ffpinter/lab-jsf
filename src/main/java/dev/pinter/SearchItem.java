package dev.pinter;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SearchItem {
    @JsonProperty("external_urls")
    private SearchExternalUrl externalUrl;

    @JsonProperty("followers")
    private SearchFollowers followers;

    @JsonProperty("genres")
    private List<String> genres;

    private String strGenres;

    @JsonProperty("href")
    private String href;

    @JsonProperty("id")
    private String id;

    @JsonProperty("images")
    private List<SearchImage> images;

    @JsonProperty("name")
    private String name;

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

    public List<String> getGenres() {
        return genres;
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

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SearchImage> getImages() {
        return images;
    }

    public void setImages(List<SearchImage> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                " genres=" + genres + "\n" +
                " href='" + href + "\n" +
                " id='" + id + "\n" +
                " images=" + images + "\n" +
                " name='" + name + "\n" +
                " type='" + type + "\n" +
                " popularity=" + popularity + "\n" +
                " uri='" + uri + "\n" +
                "}\n\n\n\n";
    }
}
