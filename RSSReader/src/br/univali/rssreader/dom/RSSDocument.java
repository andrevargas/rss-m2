
package br.univali.rssreader.dom;


public class RSSDocument {

    private final RSSChannel channel;

    public RSSDocument(RSSChannel channel) {
        this.channel = channel;
    }
    
    public RSSChannel getChannel() {
        return channel;
    }

}
