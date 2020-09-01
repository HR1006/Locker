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
                ticket.setLocker(locker);
                break;
            }
        }
        if (ticket == null) {
            throw new LockerFullException(LockerFullException.DEPOSIT_BAG_FAILED);
        }
        return ticket;
    }

    public Bag pickUpBag(Ticket ticket) {
        Locker locker = ticket.getLocker();
        if (locker == null) {
            throw new InvalidTicketException(InvalidTicketException.PICK_UP_BAG_FAILED);
        }
        return locker.pickUpBag(ticket);
    }
}
