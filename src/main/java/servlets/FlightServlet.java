package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.FlightsModel;
import services.FlightService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class FlightServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
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
                case "login":
                    List<FlightsModel> FlightList = FlightService.getAllFlights(payload.getUserName());
                    if (FlightList != null) {
                        String json = mapper.writeValueAsString(FlightList);
                        resp.setStatus(202);
                        resp.getWriter().print(json);
                    } else {
                        resp.setStatus(406);
                    }
                    break;
            }
        } catch(IOException e) {
            e.printStackTrace();
            //TODO: Replace me with file logging!
        }
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        int flightNumber = Integer.parseInt(req.getParameter("flight_number"));
        FlightService.deleteFlight(flightNumber);

        resp.setStatus(200);
    }
}
