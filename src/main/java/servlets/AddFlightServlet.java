package servlets;

import models.FlightsModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddFlightServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String origin = req.getParameter("origin");
        String dest = req.getParameter("destination");
        int flightNumber = Integer.parseInt(req.getParameter("flight_number"));
        //date tinkering
        Date eta = new Date();
        try {
            Date begin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("12/10/2021 06:00:00");
            Date end = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("12/10/2021 09:00:00");
            eta.setTime(end.getTime() - begin.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        FlightsModel newFlight = new FlightsModel(origin, dest, flightNumber, eta);

        PrintWriter out = resp.getWriter();
        out.println(newFlight.getOrigin() + ", " + newFlight.getDestination() + ", " + newFlight.getEta() + ", " +
                newFlight.getFlightNumber());
    }
}
