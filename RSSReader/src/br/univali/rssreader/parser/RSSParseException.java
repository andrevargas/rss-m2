
package br.univali.rssreader.parser;


public class RSSParseException extends Exception {

    private static final long serialVersionUID = 1L;

    public RSSParseException() {}

    public RSSParseException(String msg) {
        super(msg);
    }

    public RSSParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
