package de.medieninformatik.server;

import de.medieninformatik.common.Seat;
import de.medieninformatik.common.Student;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("studenten") // Teil des Resource -Pfades

public class SeatRest {
    private static final int ROWS = 10;
    private static final int COLUMNS = 20;
    private static Seat empty;
    private static Seat[][] seats;

    static {
        empty = new Seat();
        empty.setBooked(false);
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                seats[i][j] = empty;
            }
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response addReservation(int row, int column, String name) {
        Seat curr = seats[row][column];
        Response response;
        if (curr.isBooked()){
            response = Response.noContent().status(Response.Status.CONFLICT).build();
        } else {
            String[] splitName = name.split(" ");
            curr.setFirstName(splitName[0]);
            curr.setLastName(splitName[1]);
            curr.setBooked(true);

            response = Response.noContent().status(Response.Status.OK).build();
        }
        return response;
    }
}
