
package br.univali.rssreader.reader;

public class RSSReadException extends Exception {

    private static final long serialVersionUID = 1L;

    public RSSReadException() {}

    public RSSReadException(String msg) {
        super(msg);
    }

    public RSSReadException(String message, Throwable cause) {
        super(message, cause);
    }

}
