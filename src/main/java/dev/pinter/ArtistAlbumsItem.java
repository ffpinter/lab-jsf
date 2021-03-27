package dev.pinter;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ArtistAlbumsItem {
    @JsonProperty("album_group")
    private String albumGroup;

    @JsonProperty("album_type")
    private String albumType;

    @JsonProperty("artists")
    private List<ArtistAlbumsArtist> artistsList;

    @JsonProperty("available_markets")
    private List<String> availableMarkets;

    @JsonProperty("external_urls")
    private ArtistAlbumsExternalUrls externalUrls;

    @JsonProperty("href")
    private String href;

    @JsonProperty("id")
    private String id;

    @JsonProperty("images")
    private List<ArtistAlbumsImage> images;

    @JsonProperty("name")
    private String name;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("release_date_precision")
    private String releaseDatePrecision;

    @JsonProperty("type")
    private String type;

    @JsonProperty("uri")
    private String uri;

    @JsonProperty("total_tracks")
    private int totalTracks;


    public String getAlbumGroup() {
        return albumGroup;
    }

    public void setAlbumGroup(String albumGroup) {
        this.albumGroup = albumGroup;
    }

    public String getAlbumType() {
        return albumType;
    }

    public void setAlbumType(String albumType) {
        this.albumType = albumType;
    }

    public List<ArtistAlbumsArtist> getArtistsList() {
        return artistsList;
    }

    public void setArtistsList(List<ArtistAlbumsArtist> artistsList) {
        this.artistsList = artistsList;
    }

    public List<String> getAvailableMarkets() {
        return availableMarkets;
    }

    public void setAvailableMarkets(List<String> availableMarkets) {
        this.availableMarkets = availableMarkets;
    }

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

    public List<ArtistAlbumsImage> getImages() {
        return images;
    }

    public void setImages(List<ArtistAlbumsImage> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDatePrecision() {
        return releaseDatePrecision;
    }

    public void setReleaseDatePrecision(String releaseDatePrecision) {
        this.releaseDatePrecision = releaseDatePrecision;
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

    public int getTotalTracks() {
        return totalTracks;
    }

    public void setTotalTracks(int totalTracks) {
        this.totalTracks = totalTracks;
    }

    @Override
    public String toString() {
        return "ArtistAlbumsItem{" +
                "albumGroup=" + albumGroup + "\n" +
                ", albumType=" + albumType + "\n" +
                ", artistsList=" + artistsList + "\n" +
                ", availableMarkets=" + availableMarkets + "\n" +
                ", externalUrls=" + externalUrls + "\n" +
                ", href=" + href + "\n" +
                ", id=" + id + "\n" +
                ", images=" + images + "\n" +
                ", name=" + name + "\n" +
                ", releaseDate=" + releaseDate + "\n" +
                ", releaseDatePrecision=" + releaseDatePrecision + "\n" +
                ", totalTracks=" + totalTracks + "\n" +
                ", type=" + type + "\n" +
                ", uri=" + uri + "\n" +
                '}';
    }
}
