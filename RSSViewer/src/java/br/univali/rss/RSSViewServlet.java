
package br.univali.rss;

import br.univali.rssreader.dom.RSSDocument;
import br.univali.rssreader.reader.RSSReadException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.univali.rssreader.reader.RSSReader;

@WebServlet("/rss")
public class RSSViewServlet extends HttpServlet {

    private static final long serialVersionUID = -4933893483147525799L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = req.getParameter("url");
        RSSReader reader = new RSSReader(url);

        try {
            RSSDocument document = reader.read();
            req.setAttribute("channel", document.getChannel());
        } catch (RSSReadException ex) {
            req.setAttribute("error", ex.getMessage());
        }

        req.getRequestDispatcher("view.jsp")
            .forward(req, resp);

    }

}
