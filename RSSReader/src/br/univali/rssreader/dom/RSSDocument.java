
package br.univali.rssreader.dom;


public class RSSDocument {

    private String version;

    private RSSChannel channel;

    public RSSChannel getChannel() {
        return channel;
    }

    public void setChannel(RSSChannel channel) {
        this.channel = channel;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
