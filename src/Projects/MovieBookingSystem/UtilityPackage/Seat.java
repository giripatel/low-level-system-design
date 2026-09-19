package Projects.MovieBookingSystem.UtilityPackage;

import Projects.MovieBookingSystem.CommonEnums.SeatCategory;

public class Seat {
    int id;
    int row;
    SeatCategory seatCategory;

    public Seat(int id, int row, SeatCategory seatCategory) {
        this.id = id;
        this.row = row;
        this.seatCategory = seatCategory;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getId() {
        return id;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }
}
