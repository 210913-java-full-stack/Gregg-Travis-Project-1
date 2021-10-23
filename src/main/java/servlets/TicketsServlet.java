package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.TicketsModel;
import services.TicketsService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class TicketsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<TicketsModel> PassengerList = TicketsService.getAllTickets();
            String json = mapper.writeValueAsString(PassengerList);
            resp.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            InputStream requestBody = req.getInputStream();
            String requestHeader = req.getHeader("Method");
            Scanner sc = new Scanner(requestBody, StandardCharsets.UTF_8.name());
            String jsonText = sc.useDelimiter("\\A").next();
            ObjectMapper mapper = new ObjectMapper();
            TicketsModel payload = mapper.readValue(jsonText, TicketsModel.class);
            switch (requestHeader) {
                case "addTicket":
                    TicketsService.addTicket(payload);
                    break;
                case "removeTicket":
                    TicketsService.deleteTicket(payload.getTicketNumber());
                    break;
                case "checkIn":
                    TicketsService.checkInByUserName(payload.getTicketNumber(), payload.getUserName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
