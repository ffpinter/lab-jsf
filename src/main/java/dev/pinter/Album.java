/*
 * Copyright (C) 2021 - Flavio Freitas Pinter
 */

package dev.pinter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;



@JsonIgnoreProperties(ignoreUnknown = true)
public class Album {
    @JsonProperty("album_type")
    private String type;

    @JsonProperty("genres")
    private List<String> genres;

    @JsonProperty("href")
    private String href;

    @JsonProperty("id")
    private String id;

    @JsonProperty("available_markets")
    private List<String> availableMarkets;

    @JsonProperty("artists")
    private List<Artist> artists;

    @JsonProperty("name")
    private String name;

    @JsonProperty("release_date")
    private Date releaseDate;

    @JsonProperty("popularity")
    private int popularity;

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getGenres() {
        return genres;
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

    public List<String> getAvailableMarkets() {
        return availableMarkets;
    }

    public void setAvailableMarkets(List<String> availableMarkets) {
        this.availableMarkets = availableMarkets;
    }

    @Override
    public String toString() {
        return "Album{" +
                "type='" + type + "\n" +
                ", genres=" + genres +
                ", href='" + href + "\n" +
                ", id='" + id + "\n" +
                ", available_markets=" + availableMarkets + "\n" +
                ", artists=" + artists + "\n" +
                ", name='" + name + "\n" +
                ", releaseDate=" + releaseDate + "\n" +
                ", popularity=" + popularity +
                '}';
    }
}
