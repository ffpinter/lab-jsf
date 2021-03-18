package dev.pinter;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("spotifyBean")
@ViewScoped
public class SpotifyBean implements Serializable {
    private final Utils utils = new Utils();

    public Album requestAlbum(String id) {
        AccessTokenResponse accessToken = utils.getAccesssToken();
        return utils.getAlbum(accessToken.getAccessToken(), id);
    }
}
