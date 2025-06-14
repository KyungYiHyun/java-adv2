package was.v6;

import was.httpserver.ServletManager;
import was.httpserver.servlet.DiscardServlet;
import was.httpserver.servlet.HttpServer;
import was.httpserver.servlet.reflection.ReflectionServlet;
import was.v5.servlet.HomeServlet;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ServerMainV6 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        List<Object> controllers = List.of(new SiteControllerV6(), new SearchControllerV6());
        ReflectionServlet servlet = new ReflectionServlet(controllers);

        ServletManager servletManager = new ServletManager();
        servletManager.setDefaultServlet(servlet);
        servletManager.add("/",new HomeServlet());
        servletManager.add("/favicon.ico", new DiscardServlet());

        HttpServer server = new HttpServer(PORT, servletManager);
        server.start();

    }
}
