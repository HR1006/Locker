package cn.xpbootcamp.locker;

import java.util.ArrayList;
import java.util.List;

public class PrimaryLockerRobot {

    private final List<Locker> lockers = new ArrayList<>();

    public void addLocker(Locker locker) {
        lockers.add(locker);
    }

    public Ticket depositBag(Bag bag) {
        Ticket ticket = null;
        for (Locker locker : lockers) {
            if (locker.surplusCapacity() > 0) {
                ticket = locker.depositBag(bag);
                break;
            }
        }
        if (ticket == null) {
            throw new LockerFullException();
        }
        return ticket;
    }

    public Bag pickUpBag(Ticket ticket) {
        for (Locker locker : lockers) {
            if (locker.isValidTicket(ticket)) {
                return locker.pickUpBag(ticket);
            }
        }
        throw new InvalidTicketException();
    }
}
