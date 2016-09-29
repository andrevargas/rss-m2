
package br.univali.rssreader.exception;


public class RSSException extends Exception {

    private static final long serialVersionUID = -9067853533777659718L;

    public RSSException() {}

    public RSSException(String msg) {
        super(msg);
    }

    public RSSException(String message, Throwable cause) {
        super(message, cause);
    }
}
