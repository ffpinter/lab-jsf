/*
 * Copyright (C) 2021 - Flavio Freitas Pinter
 */

package dev.pinter;

import org.glassfish.jersey.logging.LoggingFeature;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpotAPI {

    public AccessTokenResponse getAccessToken(String authToken) {
        return request(AccessTokenResponse.class,
                "https://accounts.spotify.com/api/token",
                authToken,
                true,
                null);
    }

    public Album getAlbum(String authToken, String id) {
        return request(Album.class,
                "https://api.spotify.com/v1/albums/" + id,
                authToken,
                false,
                null);
    }

    public Artist getArtist(String authToken, String id) {
        return request(Artist.class,
                "https://api.spotify.com/v1/artists" + id,
                authToken,
                false,
                null);
    }

    public <T> T request(Class<T> type, String url, String authToken, boolean accessToken, HashMap<String,
            List<String>> queryParams) {
        Logger logger = Logger.getLogger(getClass().getName());

        Feature feature = new LoggingFeature(logger, Level.INFO, null, null);

        WebTarget target = ClientBuilder.newClient().register(feature)
                .target(url);

        if (queryParams != null) {
            for (Map.Entry<String, List<String>> entry : queryParams.entrySet()) {
                for (String s : entry.getValue()) {
                    target = target.queryParam(entry.getKey(), s);
                    System.out.println(target);
                }
            }
        }

        Invocation.Builder builder1 = target.request(MediaType.APPLICATION_JSON_TYPE);
        if (accessToken) {
            return builder1.header("Authorization", "Basic " + authToken)
                    .post(Entity.entity(new Form("grant_type", "client_credentials"),
                            MediaType.APPLICATION_FORM_URLENCODED_TYPE), type);
        } else {
            return builder1.header("Authorization", "Bearer " + authToken)
                    .get(type);
        }
    }

    public String getEncodedIds() {
        return Base64.getEncoder()
                .encodeToString("4c13d223b3fd459d8cd39564e9309589:18eef649a5f04e2b948b3981f7eb5349".getBytes());
    }
}
