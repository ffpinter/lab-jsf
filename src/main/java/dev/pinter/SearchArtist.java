package dev.pinter;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SearchArtist {
    @JsonProperty("href")
    private String href;

    @JsonProperty("limit")
    private int limit;

    @JsonProperty("items")
    private List<SearchItem> items;

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

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<SearchItem> getItems() {
        return items;
    }

    public void setItems(List<SearchItem> items) {
        this.items = items;
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
        return "SearchArtist{" +
                "href='" + href + "\n" +
                ", limit=" + limit +
                ", items=" + items +
                ", next='" + next + "\n" +
                ", offset=" + offset +
                ", previous='" + previous + "\n" +
                ", total=" + total +
                '}';
    }
}
