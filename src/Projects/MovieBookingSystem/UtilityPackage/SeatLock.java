package Projects.MovieBookingSystem.UtilityPackage;

import java.time.Instant;
import java.util.Date;

public class SeatLock {
    private Seat seat;
    private Show show;
    private User lockedBy;
    private Integer timeoutInSeconds;
    private Date lockTime;

    public SeatLock(Seat seat, Show show, User lockedBy, Date lockTime, Integer timeoutInSeconds) {
        this.seat = seat;
        this.show = show;
        this.lockedBy = lockedBy;
        this.timeoutInSeconds = timeoutInSeconds;
        this.lockTime = lockTime;
    }

    public boolean isLockExpired() {
        Instant lockInstant = lockTime.toInstant().plusSeconds(timeoutInSeconds);
        Instant currentInstant = new Date().toInstant();
        return lockInstant.isBefore(currentInstant);
    }

    public Seat getSeat() {
        return seat;
    }

    public Show getShow() {
        return show;
    }

    public User getLockedBy() {
        return lockedBy;
    }

    public Integer getTimeoutInSeconds() {
        return timeoutInSeconds;
    }

    public Date getDateLocked() {
        return lockTime;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public void setLockedBy(User lockedBy) {
        this.lockedBy = lockedBy;
    }

    public void setTimeoutInSeconds(Integer timeoutInSeconds) {
        this.timeoutInSeconds = timeoutInSeconds;
    }

    public void setDateLocked(Date lockTime) {
        this.lockTime = lockTime;
    }
}
