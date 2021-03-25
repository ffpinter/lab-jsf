package dev.pinter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchRoot {
    @JsonProperty("artist")
    private SearchArtist searchArtist;

    public SearchArtist getSearchArtist() {
        return searchArtist;
    }

    public void setSearchArtist(SearchArtist searchArtist) {
        this.searchArtist = searchArtist;
    }

    @Override
    public String toString() {
        return "SearchRoot{" +
                "searchArtist=" + searchArtist +
                '}';
    }
}
