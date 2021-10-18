package servlets;

import models.FlightsModel;
import services.FlightService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FlightServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String origin = req.getParameter("origin");
        String dest = req.getParameter("destination");
        int flightNumber = Integer.parseInt(req.getParameter("flight_number"));
        Date begin = new Date();
        Date end = new Date();
        try {
            begin = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse(req.getParameter("start_time"));
            end = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse(req.getParameter("end_time"));
            System.out.println(begin);
            System.out.println(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        FlightsModel newFlight = new FlightsModel(origin, dest, flightNumber, begin, end);

        PrintWriter out = resp.getWriter();
        out.println(newFlight.getOrigin() + ", " + newFlight.getDestination() +", " + newFlight.getFlightNumber() + ", "
                + newFlight.getBegin() + ", " + newFlight.getEnd());
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int flightNumber = Integer.parseInt(req.getParameter("flight_number"));
        FlightService.deleteFlight(flightNumber);

        resp.setStatus(200);
    }
}
