
package br.univali.rssreader.reader;

import br.univali.rssreader.exception.RSSReadException;
import br.univali.rssreader.dom.RSSDocument;
import br.univali.rssreader.exception.RSSParseException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import br.univali.rssreader.parser.RSSParser;


public class RSSReader {

    private final String address;

    public RSSReader(String address) {
        this.address = address;
    }

    public RSSDocument read() throws RSSReadException, RSSParseException {

        try {

            URL url = new URL(address);

            SAXBuilder builder = new SAXBuilder();
            Document xmlDocument = builder.build(url.openStream());

            RSSParser parser = new RSSParser();
            RSSDocument document = parser.parseDocument(xmlDocument);

            return document;

        } catch (MalformedURLException ex) {
            throw new RSSReadException("A URL informada é inválida.", ex);
        } catch (IOException ex) {
            throw new RSSReadException("Ocorreu um erro durante as operações de E/S.", ex);
        } catch (JDOMException ex) {
            throw new RSSReadException("Ocorreu um erro durante o parsing do XML.", ex);
        }

    }

}
