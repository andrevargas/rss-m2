
package br.univali.rssreader.parser;

import br.univali.rssreader.dom.RSSChannel;
import br.univali.rssreader.dom.RSSDocument;
import br.univali.rssreader.dom.RSSItem;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;


public class RSSParser {

    public RSSDocument parseDocument(Document xmlDocument) throws RSSParseException {

        Element xmlRoot = xmlDocument.getRootElement();
        Element xmlChannel = xmlRoot.getChild("channel");

        RSSChannel channel = new RSSChannel();
        channel.setItems(parseItems(xmlChannel));

        RSSDocument document = new RSSDocument();
        document.setVersion(xmlRoot.getAttributeValue("version"));
        document.setChannel(channel);

        return document;

    }

    private List<RSSItem> parseItems(Element xmlChannel) throws RSSParseException {

        List<RSSItem> items = new ArrayList<>();
        List<Element> elements = xmlChannel.getChildren("item");

        for (Element element : elements) {

            RSSItem item = new RSSItem();

            item.setTitle(element.getChildText("title"));
            item.setAuthor(element.getChildText("author"));
            item.setDescription(element.getChildText("description"));
            item.setLink(element.getChildText("link"));

            try {
                DateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
                Date pubDate = formatter.parse(element.getChildText("pubDate"));
                item.setPubDate(pubDate);
            } catch (ParseException ex) {
                throw new RSSParseException("Data de publicação possui formato inválido.", ex);
            }

            items.add(item);

        }

        return items;

    }

}
