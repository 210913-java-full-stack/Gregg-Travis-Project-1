package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.UserModel;
import services.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
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
                UserService.saveNewUser(payload);
                break;
            case "login":
                System.out.println("made to login servlet case");
                UserModel checkUser;
                checkUser = UserService.getUserByUserPass(payload.getUserName(), payload.getPass());
                if (checkUser != null) {
                    String json = mapper.writeValueAsString(checkUser);
                    resp.setStatus(202);
                    resp.getWriter().print(json);
                } else {
                    resp.setStatus(406);
                }
                break;
        }
    }
}
