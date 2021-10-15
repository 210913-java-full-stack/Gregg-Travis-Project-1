package servlets;

import services.FlightService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CancelFlightServlet extends HttpServlet {
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int flightNumber = Integer.parseInt(req.getParameter("flight_number"));
        FlightService.deleteFlight(flightNumber);

        resp.setStatus(200);
    }
}
