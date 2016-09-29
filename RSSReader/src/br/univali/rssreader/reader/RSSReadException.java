
package br.univali.rssreader.reader;

public class RSSReadException extends Exception {

    private static final long serialVersionUID = 7471879800578241077L;

    public RSSReadException() {}

    public RSSReadException(String msg) {
        super(msg);
    }

    public RSSReadException(String message, Throwable cause) {
        super(message, cause);
    }

}
