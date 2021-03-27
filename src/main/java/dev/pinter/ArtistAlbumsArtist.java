package dev.pinter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArtistAlbumsArtist {
    @JsonProperty("external_urls")
    private ArtistAlbumsExternalUrls externalUrls;

    @JsonProperty("href")
    private String href;

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("uri")
    private String uri;

    public ArtistAlbumsExternalUrls getExternalUrls() {
        return externalUrls;
    }

    public void setExternalUrls(ArtistAlbumsExternalUrls externalUrls) {
        this.externalUrls = externalUrls;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "ArtistAlbumsArtist{" + "\n" +
                "externalUrls=" + externalUrls + "\n" +
                ", href=" + href + "\n" +
                ", id=" + id + "\n" +
                ", name=" + name + "\n" +
                ", type=" + type + "\n" +
                ", uri=" + uri + "\n" +
                '}';
    }
}
