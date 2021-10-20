package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.FlightsModel;
import models.UserModel;
import services.FlightService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FlightServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        InputStream requestBody = req.getInputStream();
        String requestHeader = req.getHeader("Method");
        Scanner sc = new Scanner(requestBody, StandardCharsets.UTF_8.name());
        String jsonText = sc.useDelimiter("\\A").next();
        ObjectMapper mapper = new ObjectMapper();
        FlightsModel payload = mapper.readValue(jsonText, FlightsModel.class);
        switch (requestHeader) {
            case "addFlight":
                FlightService.addFlight(payload);
                break;
//            case "login":
//                UserModel checkUser;
//                //checkUser = UserService.getUserByUserPass(payload.getUserName(), payload.getPass());
//                //if (checkUser != null) {
//                    String json = mapper.writeValueAsString(checkUser);
//                    resp.setStatus(202);
//                    resp.getWriter().print(json);
//                } else {
//                    resp.setStatus(406);
//                }
//                break;
        }
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int flightNumber = Integer.parseInt(req.getParameter("flight_number"));
        FlightService.deleteFlight(flightNumber);

        resp.setStatus(200);
    }
}
