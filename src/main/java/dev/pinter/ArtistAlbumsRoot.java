package dev.pinter;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ArtistAlbumsRoot {
    @JsonProperty("href")
    private String href;

    @JsonProperty("items")
    private List<ArtistAlbumsItem> itemsList;

    @JsonProperty("limit")
    private int limit;

    @JsonProperty("next")
    private String next;

    @JsonProperty("offset")
    private int offset;

    @JsonProperty("previous")
    private String previous;

    @JsonProperty("total")
    private int total;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<ArtistAlbumsItem> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<ArtistAlbumsItem> itemsList) {
        this.itemsList = itemsList;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ArtistAlbumsRoot{" + "\n" +
                "href=" + href + "\n" +
                ", itemsList=" + itemsList + "\n" +
                ", limit=" + limit + "\n" +
                ", next=" + next + "\n" +
                ", offset=" + offset + "\n" +
                ", previous=" + previous + "\n" +
                ", total=" + total + "\n" +
                '}';
    }
}
