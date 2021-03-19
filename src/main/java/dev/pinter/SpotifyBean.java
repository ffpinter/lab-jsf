package dev.pinter;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Base64;

@Named("spotifyBean")
@ViewScoped
public class SpotifyBean implements Serializable {
    private final Utils utils = new Utils();
    private String albumId;
    private boolean rendered = false;

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

    public Album requestAlbum() {
        setRendered(true);
        AccessTokenResponse accessToken = utils.getAccesssToken();
        return utils.getAlbum(accessToken.getAccessToken(), albumId);
    }
}
