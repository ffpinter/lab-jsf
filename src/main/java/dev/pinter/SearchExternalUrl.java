package dev.pinter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchExternalUrl {
    @JsonProperty("spotify")
    private String spotify;

    public String getSpotify() {
        return spotify;
    }

    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }
}
