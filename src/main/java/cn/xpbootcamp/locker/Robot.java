package cn.xpbootcamp.locker;

import java.util.ArrayList;
import java.util.List;

public abstract class Robot {
    private final List<Locker> lockers = new ArrayList<>();

    public List<Locker> getLockers() {
        return lockers;
    }

    public void addLocker(Locker locker) {
        lockers.add(locker);
    }

    public abstract Ticket depositBag(Bag bag);

    public boolean isValidTicket(Ticket ticket) {
        for (Locker locker : getLockers()) {
            if (locker.isValidTicket(ticket)) {
                return true;
            }
        }
        return false;
    }

    public Bag pickUpBag(Ticket ticket) {
        for (Locker locker : lockers) {
            if (locker.isValidTicket(ticket)) {
                return locker.pickUpBag(ticket);
            }
        }
        throw new InvalidTicketException();
    }

    public abstract Ticket depositBagOrNot(Bag bag);
}
