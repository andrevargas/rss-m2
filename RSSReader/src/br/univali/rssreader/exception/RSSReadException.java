
package br.univali.rssreader.exception;


public class RSSReadException extends RSSException {

    private static final long serialVersionUID = 7471879800578241077L;

    public RSSReadException() {}

    public RSSReadException(String msg) {
        super(msg);
    }

    public RSSReadException(String message, Throwable cause) {
        super(message, cause);
    }

}
