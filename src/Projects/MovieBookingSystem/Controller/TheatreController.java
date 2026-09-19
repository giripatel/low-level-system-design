package Projects.MovieBookingSystem.Controller;

import Projects.MovieBookingSystem.CommonEnums.SeatCategory;
import Projects.MovieBookingSystem.Service.TheatreService;
import Projects.MovieBookingSystem.UtilityPackage.Screen;
import Projects.MovieBookingSystem.UtilityPackage.Theatre;

public class TheatreController {

    private TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    public int createTheatre(String theatreName) throws Exception {
        return theatreService.createtheatre(theatreName).getId();
    }

    public int createScreenInTheatre(String screenName, int theatreId) throws Exception {
        Theatre theatre = theatreService.getTheatre(theatreId);
        return theatreService.createScreenInTheatre(screenName, theatre).getId();
    }

    public int createSeatInScreen(Integer rowNo, SeatCategory seatCategory, int screenId) throws Exception {
        Screen screen = theatreService.getScreen(screenId);
        return theatreService.createSeatInScreen(rowNo, seatCategory, screen).getId();
    }
}
