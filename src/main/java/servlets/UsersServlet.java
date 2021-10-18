package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.UserModel;
import services.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UsersServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        InputStream requestBody = req.getInputStream();
        Scanner sc = new Scanner(requestBody, StandardCharsets.UTF_8.name());
        String jsonText = sc.useDelimiter("\\A").next();
        ObjectMapper mapper = new ObjectMapper();
        UserModel payload = mapper.readValue(jsonText, UserModel.class);
        UserService.saveNewUser(payload);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserModel checkUser = new UserModel();
        InputStream requestBody = req.getInputStream();
        Scanner sc = new Scanner(requestBody, StandardCharsets.UTF_8.name());
        String jsonText = sc.useDelimiter("\\A").next();
        ObjectMapper mapper = new ObjectMapper();
        UserModel payload = mapper.readValue(jsonText, UserModel.class);
        checkUser = UserService.getUserByUserPass(payload.getUserName(), payload.getPass());
        if (checkUser != null) {
            //return UserModel to website using JSON
        } else {
            //Return message stating "Username/Password Combination Not Valid"
        }
    }
}
