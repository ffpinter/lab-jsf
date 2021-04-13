package dev.pinter;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.primefaces.model.StreamedContent;

import java.util.List;

public class ArtistAlbumsItem extends Album {
    @JsonProperty("album_group")
    private String albumGroup;

    @JsonProperty("artists")
    private List<ArtistAlbumsArtist> artistsList;

    @JsonProperty("external_urls")
    private ArtistAlbumsExternalUrls externalUrls;

    @JsonProperty("images")
    private List<ArtistAlbumsImage> images;

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

    public List<ArtistAlbumsArtist> getArtistsList() {
        return artistsList;
    }

    public void setArtistsList(List<ArtistAlbumsArtist> artistsList) {
        this.artistsList = artistsList;
    }

    public ArtistAlbumsExternalUrls getExternalUrls() {
        return externalUrls;
    }

    public void setExternalUrls(ArtistAlbumsExternalUrls externalUrls) {
        this.externalUrls = externalUrls;
    }

    public List<ArtistAlbumsImage> getImages() {
        return images;
    }

    public void setImages(List<ArtistAlbumsImage> images) {
        this.images = images;
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
                ", artistsList=" + artistsList + "\n" +
                ", externalUrls=" + externalUrls + "\n" +
                ", images=" + images + "\n" +
                ", releaseDatePrecision=" + releaseDatePrecision + "\n" +
                ", totalTracks=" + totalTracks + "\n" +
                ", type=" + type + "\n" +
                ", uri=" + uri + "\n" +
                '}';
    }
}
