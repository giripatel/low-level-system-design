package Projects.MovieBookingSystem.ConcreteLockProviders;

import Projects.MovieBookingSystem.Interfaces.ISeatLockProvider;
import Projects.MovieBookingSystem.UtilityPackage.Seat;
import Projects.MovieBookingSystem.UtilityPackage.SeatLock;
import Projects.MovieBookingSystem.UtilityPackage.Show;
import Projects.MovieBookingSystem.UtilityPackage.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SeatLockProvider implements ISeatLockProvider {

    private final Integer lockTimeout;

    private final ConcurrentHashMap<Show, Map<Seat, SeatLock>> locks;

    public SeatLockProvider(Integer lockTimeout) {
        this.lockTimeout = lockTimeout;
        this.locks = new ConcurrentHashMap<>();
    }


    /**
     * @param show
     * @param seats
     * @param user
     */
    @Override
    public void lockSeats(Show show, List<Seat> seats, User user) throws Exception {
        Map<Seat, SeatLock> seatLocks = locks.computeIfAbsent(show, k -> new ConcurrentHashMap<>());
        synchronized (seatLocks) {

            // validate all seats are available
            for (Seat seat: seats) {
                if (seatLocks.containsKey(seat)) {
                    SeatLock existingLock = seatLocks.get(seat);
                    if (!existingLock.isLockExpired()) {
                        throw new Exception(
                                "Seat " + seat.getId() + " is already locked"
                        );
                    }
                }
            }

            Date date = new Date();
            for (Seat seat: seats) {
                SeatLock newSeatLock = new SeatLock(seat, show, user, date, lockTimeout);
                seatLocks.put(seat, newSeatLock);
            }
        }
    }

    /**
     * @param show
     * @param seats
     * @param user
     */
    @Override
    public void unLockSeats(Show show, List<Seat> seats, User user) {

        Map<Seat, SeatLock> seatLock = locks.get(show);
        if (seatLock == null) return;

        synchronized (seatLock) {
            for (Seat seat: seats) {
                SeatLock lock = seatLock.get(seat);
                if (lock != null && lock.getLockedBy().equals(user)) {
                    seatLock.remove(seat);
                }
            }
        }
    }

    /**
     * @param show
     * @param seat
     * @param user
     * @return
     */
    @Override
    public boolean validateLock(Show show, Seat seat, User user) {

        Map<Seat, SeatLock> seatLocks = locks.get(show);

        if (seatLocks == null) {
            System.out.println("Seat locks are null");
            return false;
        }
        synchronized (seatLocks){
            SeatLock seatLock = seatLocks.get(seat);
            return seatLock != null && !seatLock.isLockExpired()
                    && seatLock.getLockedBy().equals(user);
        }
    }

    /**
     * @param show
     * @return
     */
    @Override
    public List<Seat> getLockedSeats(Show show) {
        Map<Seat, SeatLock> activeLocks = locks.get(show);
        if (activeLocks == null) {
            return Collections.emptyList();
        }

        synchronized (activeLocks) {
            List<Seat> activeLockList = new ArrayList<>();

            for (Map.Entry<Seat, SeatLock> entry: activeLocks.entrySet()) {
                if (!entry.getValue().isLockExpired()) {
                    activeLockList.add(entry.getKey());
                }
            }
            return activeLockList;
        }
    }
}
