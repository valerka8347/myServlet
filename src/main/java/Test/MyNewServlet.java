package Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/two")
public class MyNewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> headers = req.getHeaderNames();
        PrintWriter pw = resp.getWriter();
        while (headers.hasMoreElements()) {
            String parameterName = (String) headers.nextElement();
            String parameterValue = req.getHeader(parameterName);
            pw.println("<h3>" + parameterName + ": " + parameterValue + "</h3>" + "\n");
        }

        /*String URI = req.getRequestURI();
        String URL = String.valueOf(req.getRequestURL());
        int session = req.getContentLength();
        String info = req.getPathInfo();
        String method = req.getMethod();
        String path = req.getPathInfo();
        String name = req.getServerName();
        Cookie[] cookie = req.getCookies();
        int port = req.getServerPort();




        PrintWriter pw = resp.getWriter();
        pw.println("URI: " + URI);
        pw.println("URL: " + URL );
        pw.println("session: " + session);
        pw.println("name: " + name);
        pw.println("method: " + method );
        pw.println("path: " + path);
        pw.println("info: " + info);
        pw.println("cookie: " + cookie);
        pw.println("port: " + port);*/



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
