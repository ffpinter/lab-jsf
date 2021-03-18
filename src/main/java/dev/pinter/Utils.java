package dev.pinter;

public class Utils {
    private final SpotifyAPI spotifyAPI = new SpotifyAPI();

    public AccessTokenResponse getAccesssToken() {
        String encodedAuth = spotifyAPI.getEncodedIds();
        return spotifyAPI.getAccessToken(encodedAuth);
    }

    public Album getAlbum(String authToken, String id) {
        return spotifyAPI.getAlbum(authToken, id);
    }

    public Artist getArtist(String authToken, String id) {
        return spotifyAPI.getArtist(authToken, id);
    }
}
