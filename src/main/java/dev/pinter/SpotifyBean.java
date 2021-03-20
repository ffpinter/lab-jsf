package dev.pinter;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.NotAuthorizedException;
import java.awt.*;
import java.io.Serializable;
import java.util.List;

@Named("spotifyBean")
@ViewScoped
public class SpotifyBean implements Serializable {
    private final Utils utils = new Utils();
    private String albumId;
    private boolean rendered = false;
    private List<Album> albums;

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

    public void toggleRendered(){
        this.rendered = !rendered;
    }

    public void requestAlbum(ActionEvent event) {
//        5PORx6PL7CdOywSJuGVrnc
        setRendered(true);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        AccessTokenResponse accessToken = utils.getAccesssToken();
        if(accessToken == null){
            throw new NotAuthorizedException("Error: invalid token");
        }
        System.out.println(accessToken.getAccessToken());
        System.out.println(albumId);
        albums.add(utils.getAlbum(accessToken.getAccessToken(), albumId));
    }
}
