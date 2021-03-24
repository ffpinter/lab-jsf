package dev.pinter;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.NotAuthorizedException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("spotifyBean")
@ViewScoped
public class SpotifyBean implements Serializable {
    private final SpotifyService spotifyService = new SpotifyService();
    private String albumId;
    private boolean rendered = false;
    private List<Album> albums = new ArrayList<>(10);
    private String searchArtist;
    private SearchResponse searchResult;

    public String getSearchArtist() {
        return searchArtist;
    }

    public void setSearchArtist(String searchArtist) {
        this.searchArtist = searchArtist;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public boolean isRendered() {
        return rendered;
    }

    public void setRendered(boolean rendered) {
        this.rendered = rendered;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public void toggleRendered() {
        this.rendered = !rendered;
    }

    public void requestAlbum(ActionEvent event) {
//        5PORx6PL7CdOywSJuGVrnc
        setRendered(true);
        AccessTokenResponse accessToken = spotifyService.getAccesssToken();
        if (accessToken == null) {
            throw new NotAuthorizedException("Error: invalid token");
        }
        System.out.println(accessToken);
        System.out.println(albumId);
        if (albumId.length() == 0) {
            throw new RuntimeException("Invalid id");
        }
        albums.add(spotifyService.getAlbum(accessToken.getAccessToken(), albumId));
    }

    public void searchArtist(ActionEvent event){
        searchResult = spotifyService.searchArtist(searchArtist, spotifyService.getAccesssToken().getAccessToken());
        System.out.println(searchResult);
    }
}
