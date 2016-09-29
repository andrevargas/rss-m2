
package br.univali.rssreader.parser;

import br.univali.rssreader.dom.RSSChannel;
import br.univali.rssreader.dom.RSSChannelImage;
import br.univali.rssreader.dom.RSSDocument;
import br.univali.rssreader.dom.RSSItem;
import br.univali.rssreader.exception.RSSParseException;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;


public class RSSParser {

    public RSSDocument parseDocument(Document xmlDocument) throws RSSParseException {

        Element xmlRoot = xmlDocument.getRootElement();

        if (!xmlRoot.getName().equals("rss")) {
            throw new RSSParseException("O documento informado não é um feed RSS válido.");
        }

        Element xmlChannel = xmlRoot.getChild("channel");

        if (xmlChannel == null) {
            throw new RSSParseException("O documento RSS não possui um canal.");
        }

        RSSChannel channel = parseChannel(xmlChannel);
        RSSDocument document = new RSSDocument(channel);

        return document;

    }

    private List<RSSItem> parseItems(Element xmlChannel) {

        List<RSSItem> items = new ArrayList<>();
        List<Element> elements = xmlChannel.getChildren("item");

        for (Element element : elements) {

            RSSItem item = new RSSItem();

            item.setTitle(element.getChildText("title"));
            item.setAuthor(element.getChildText("author"));
            item.setDescription(element.getChildText("description"));
            item.setLink(element.getChildText("link"));
            item.setPubDate(element.getChildText("pubDate"));

            items.add(item);

        }

        return items;

    }


    private RSSChannel parseChannel(Element xmlChannel) {

        String title = xmlChannel.getChildText("title");

        RSSChannelImage image = new RSSChannelImage();

        if (xmlChannel.getChild("image") != null) {

            Element xmlImage = xmlChannel.getChild("image");
            image.setUrl(xmlImage.getChildText("url"));
            image.setTitle(xmlImage.getChildText("title"));
            image.setLink(xmlImage.getChildText("link"));

        }

        List<RSSItem> items = parseItems(xmlChannel);

        return new RSSChannel(title, image, items);

    }

}
