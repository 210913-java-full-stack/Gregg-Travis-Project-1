package servlets;

import models.UserModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String user = req.getParameter("user_name");
        String pass = req.getParameter("password");
        String fName = req.getParameter("first_name");
        String lName = req.getParameter("last_name");

        UserModel newUser = new UserModel(user, pass, fName, lName, false);

        PrintWriter out = resp.getWriter();
        out.println(newUser.getUserName() + ", " + newUser.getPass() + ", " + newUser.getFirstName() + ", " +
                newUser.getLastName() + ", " + newUser.isRole());


    }
}
