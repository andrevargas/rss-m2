
package br.univali.rssreader.dom;

import java.util.List;


public class RSSChannel {
    
    private final String title;
    private final RSSChannelImage image;
    private final List<RSSItem> items;

    public RSSChannel(String title, RSSChannelImage image, List<RSSItem> items) {
        this.title = title;
        this.image = image;
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public RSSChannelImage getImage() {
        return image;
    }

    public List<RSSItem> getItems() {
        return items;
    }
    
}
