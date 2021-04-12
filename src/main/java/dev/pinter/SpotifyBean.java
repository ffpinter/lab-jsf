package dev.pinter;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.NotAuthorizedException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

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
    private StreamedContent albumImage;

    public String getSearchArtistName() {
        return searchArtistName;
    }

    public StreamedContent getAlbumImage() {
        return albumImage;
    }

    public void setAlbumImage(StreamedContent albumImage) {
        this.albumImage = albumImage;
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
        artistAlbumsList = aar.getItemsList();
        System.out.println(aar);
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

        // Removes duplicated infos
        for (int i = 0; i <= artistAlbumsList.size() - 1; i++) {
            if (artistAlbumsList.get(i).getName().equals(artistAlbumsList.get(i + 1).getName()) ||
                    artistAlbumsList.get(i).getId().equals(artistAlbumsList.get(i + 1).getId()) ||
                    artistAlbumsList.get(i).getReleaseDate().equals(artistAlbumsList.get(i + 1).getReleaseDate()) ||
                    artistAlbumsList.get(i).getTotalTracks() == artistAlbumsList.get(i + 1).getTotalTracks()) {
                artistAlbumsList.remove(i + 1);

                //StreamedContent Image from URL
                URL imageUrl = new URL(artistAlbumsList.get(i).getImages().get(i).getUrl());
                InputStream is = imageUrl.openStream();
                String mimeType = URLConnection.guessContentTypeFromStream(is);
                albumImage = DefaultStreamedContent.builder().contentType(mimeType).build();
            }
        }
    }

    public String strList(List<String> genres) {
        return genres.toString().replace("[", "").replace("]", "");
    }
}
