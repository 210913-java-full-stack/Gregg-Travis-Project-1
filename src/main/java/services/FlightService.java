package services;

import models.FlightsModel;

public class FlightService {
    public static void deleteFlight(int id) {
        FlightsModel flight = new FlightsModel(id);
        //Here we will call the delete method on the session object
        return;
    }
}
