package dev.pinter;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.NotAuthorizedException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Bean do spotify
 */
@Named("spotifyBean")
@ViewScoped
public class SpotifyBean implements Serializable {
    private final SpotifyService spotifyService = new SpotifyService();
    /**
     * ID de um album
     */
    private String albumId;
    private boolean rendered = false;
    private List<Album> albums = new ArrayList<>(100000);
    private String searchArtistName;
    private SearchRoot response;
    private List<SearchItem> artists = new ArrayList<>(100000);
    private List<ArtistAlbumsItem> artistAlbumsList = new ArrayList<>(100000);
    private List<String> urls = new ArrayList<>(100000);

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public String getSearchArtistName() {
        return searchArtistName;
    }

    /**
     * Setter @see searchArtistName
     *
     * @param searchArtistName nome do artista
     */

    public void setSearchArtistName(String searchArtistName) {
        this.searchArtistName = searchArtistName;
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

    public SearchRoot getResponse() {
        return response;
    }

    public void setResponse(SearchRoot response) {
        this.response = response;
    }

    public List<SearchItem> getArtists() {
        return artists;
    }

    public void setArtists(List<SearchItem> artists) {
        this.artists = artists;
    }

    public List<ArtistAlbumsItem> getArtistAlbumsList() {
        return artistAlbumsList;
    }

    public void setArtistAlbumsList(List<ArtistAlbumsItem> artistAlbumsList) {
        this.artistAlbumsList = artistAlbumsList;
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

    public void requestArtistAlbums(String at, String id) {
        ArtistAlbumsRoot aar = spotifyService.getArtistAlbums(at, id);
        artistAlbumsList = aar.getItemsList().stream().distinct().collect(Collectors.toList());
        artistAlbumsList.sort(Comparator.comparing(Album::getName));

        HashMap<String,Album> albums = new HashMap<>();
        aar.getItemsList().forEach(f -> { albums.put(f.getName(),f); });
        System.out.println(albums);
    }

    /**
     * Método que busca os albums de um artista pelo seu nome @see SpotifyBean#requestArtisAlbums
     *
     * @param event blablablabla
     */
    public void searchArtist(ActionEvent event) throws IOException {
        //Search Artist Albums
        String at = spotifyService.getAccesssToken().getAccessToken();
        response = spotifyService.searchArtist(searchArtistName, at);
        SearchItem si = response.getSearchArtist().getItems().get(0);
        String id = si.getId();
        requestArtistAlbums(at, id);

//        artistAlbumsList.sort(Comparator.comparing(Album::getName));
//        List<ArtistAlbumsItem> albumsList = artistAlbumsList.stream().distinct().collect(Collectors.toList());
        // Removes duplicated infos
//        for (int i = 0; i < artistAlbumsList.size(); i++) {
//            System.out.println(artistAlbumsList.get(i).getImages().get(i).getUrl());
//            ArtistAlbumsItem currentAlbum = artistAlbumsList.get(i);
//            ArtistAlbumsItem nextAlbum = artistAlbumsList.get(i + 1);
//            if (currentAlbum.getName().equals(nextAlbum.getName()) || currentAlbum.getId().equals(nextAlbum.getId()) ||
//                    currentAlbum.getReleaseDate().equals(nextAlbum.getReleaseDate()) ||
//                    currentAlbum.getTotalTracks() == nextAlbum.getTotalTracks()) {
//                System.out.println("TESTE DO IF ENORME");
//                artistAlbumsList.remove(nextAlbum);
//            }
//            if (currentAlbum.getName().equals(nextAlbum.getName()) &&
//                    currentAlbum.getReleaseDate().equals(nextAlbum.getReleaseDate())) {
//                System.out.println("TESTE DO IF ENORME2");
//                artistAlbumsList.remove(nextAlbum);
//            }
//        }
    }

    public String strList(List<String> genres) {
        return genres.toString().replace("[", "").replace("]", "");
    }
}
