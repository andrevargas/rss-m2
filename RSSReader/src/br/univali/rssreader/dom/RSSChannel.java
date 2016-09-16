
package br.univali.rssreader.dom;

import java.util.List;


public class RSSChannel {

    private List<RSSItem> items;

    public List<RSSItem> getItems() {
        return items;
    }

    public void setItems(List<RSSItem> items) {
        this.items = items;
    }

    public void addItem(RSSItem item) {
        items.add(item);
    }

    public void removeItem(RSSItem item) {
        items.add(item);
    }

}
