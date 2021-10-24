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
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UsersServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        InputStream requestBody = req.getInputStream();
        String requestHeader = req.getHeader("Method");
        Scanner sc = new Scanner(requestBody, StandardCharsets.UTF_8.name());
        String jsonText = sc.useDelimiter("\\A").next();
        ObjectMapper mapper = new ObjectMapper();
        UserModel payload = mapper.readValue(jsonText, UserModel.class);
        switch (requestHeader) {
            case "register":
                if(UserService.uniqueUsername(payload.getUserName())) {
                    UserService.saveNewUser(payload);
                    resp.setStatus(200);
                }
                else {
                    resp.setStatus(406);
                }
                break;
            case "login":
                System.out.println("made to login servlet case");
            case "userLogin":
                UserModel checkUser;
                checkUser = UserService.checkUserByUserPass(payload.getUserName(), payload.getPass());
                if (checkUser != null) {
                    String json = mapper.writeValueAsString(checkUser);
                    resp.setStatus(202);
                    resp.getWriter().print(json);
                } else {
                    resp.setStatus(406);
                }
                break;
            case "adminLogin":
                UserModel checkAdmin;
                checkAdmin = UserService.checkAdmin(payload.getUserName(), payload.getPass());
                if (checkAdmin != null && checkAdmin.getRole().equals(2)) {
                    String json = mapper.writeValueAsString(checkAdmin);
                    resp.setStatus(202);
                    resp.getWriter().print(json);
                } else {
                    resp.setStatus(406);
                }
                break;
        }
    }
}
