
package br.univali.rssreader.exception;


public class RSSParseException extends RSSException {

    private static final long serialVersionUID = -3348782355142149459L;

    public RSSParseException() {}

    public RSSParseException(String msg) {
        super(msg);
    }

    public RSSParseException(String message, Throwable cause) {
        super(message, cause);
    }

}
