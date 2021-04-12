package dev.pinter;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Test {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://i.scdn.co/image/ab67616d0000b2731b95097dd6e47dfb02b315c8");
        InputStream is = url.openStream();
        String mimeType = URLConnection.guessContentTypeFromStream(is);
        StreamedContent sc = DefaultStreamedContent.builder().contentType(mimeType).build();


    }
}
