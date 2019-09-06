package servlets;

import pojo.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/index")
public class AuthServlet extends HttpServlet {
    UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        boolean loggedIn = session != null && session.getAttribute("user") != null;
        if(loggedIn) {
            request.getRequestDispatcher("/user").forward(request, response);
        }
        else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Map<String, String> messages = new HashMap<String, String>();

        if (login == null || login.isEmpty()) {
            messages.put("login", "Please enter login");
        }

        if (password == null || password.isEmpty()) {
            messages.put("password", "Please enter password");
        }

        if (messages.isEmpty()) {
            User user = userService.getByLogin(login, password);
            if (user != null) {
                boolean admSession = user.getRole().equals("admin");
                request.getSession().setAttribute("user", user);
                response.sendRedirect(admSession?"/crud_war/admin/users":"/crud_war/user");
            } else {
                messages.put("login", "Unknown login, please try again");
                request.setAttribute("messages", messages);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
        else {
            request.setAttribute("messages", messages);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
