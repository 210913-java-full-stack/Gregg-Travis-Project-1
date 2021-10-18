package servlets;

import models.UserModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String user = req.getParameter("user_name");
        String pass = req.getParameter("password");
        boolean role;
        if (req.getParameter("role") == "User")
            role = false;
        else
            role = true;
        System.out.println();
        UserModel regUser = new UserModel(user, pass, role);

        PrintWriter out = resp.getWriter();
        out.println(regUser.getUserName() + ", " + regUser.getPass() + ", " + regUser.isRole());
    }
}
