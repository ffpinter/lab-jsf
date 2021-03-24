package dev.pinter;

import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SpotifyService {
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

    public SearchResponse searchArtist(String query, String authtoken) {
        HashMap<String, List<String>> hash = new HashMap<>();
        hash.put("q", Collections.singletonList(query));
        hash.put("type", Collections.singletonList("artist"));
        return spotifyAPI.request(SearchResponse.class,
                "https://api.spotify.com/v1/search",
                authtoken,
                false,
                hash);
    }
}
