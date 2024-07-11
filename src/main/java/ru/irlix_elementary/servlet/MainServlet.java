package ru.irlix_elementary.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class MainServlet extends HttpServlet {

    /*http://localhost:8080/hello?username=Alexandr. */

    /*
    * Сервлет работает с сессией, увеличивая счетчик visitCounter при каждом посещении страницы.
    * Если атрибут visitCounter еще не создан (при первом посещении страницы), метод getAttribute() вернет null,
    * поэтому нужно проводить проверку на null.
    * То же касается и параметров запроса. Если пользователь не передал параметр username, его значение будет null.
    * В таком случае поприветствуем пользователя как анонимного.*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer visitCounter = (Integer) session.getAttribute("visitCounter");
        if (visitCounter == null) {
            visitCounter = 1;
        } else {
            visitCounter++;
        }
        session.setAttribute("visitCounter", visitCounter);
        String username = req.getParameter("username");
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        if (username == null) {
            printWriter.write("Hello, Anonymous" + "<br>");
        } else {
            printWriter.write("Hello, " + username + "<br>");
        }
        printWriter.write("Page was visited " + visitCounter + " times.");
        printWriter.close();
    }

    /*Задача этого сервлета — перенаправлять запросы на путь “/hello”*/
    @WebServlet("/")
    public static class IndexServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        getServletContext().getRequestDispatcher("/hello").forward(req, resp);
            resp.sendRedirect(req.getContextPath() + "/hello");
        }
    }
}
