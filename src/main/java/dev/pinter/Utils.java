package dev.pinter;

import java.util.Base64;

public class Utils {
    private final SpotifyAPI spotifyAPI = new SpotifyAPI();

    public AccessTokenResponse getAccesssToken() {
        String d = Base64.getEncoder()
                .encodeToString("4c13d223b3fd459d8cd39564e9309589:18eef649a5f04e2b948b3981f7eb5349".getBytes());

        return spotifyAPI.getAccessToken(d);
    }

    public Album getAlbum(String authToken, String id) {
        return spotifyAPI.getAlbum(authToken, id);
    }

    public Artist getArtist(String authToken, String id) {
        return spotifyAPI.getArtist(authToken, id);
    }
}
