package cn.xpbootcamp.locker;

public class PrimaryLockerRobot extends Robot {
    public Ticket depositBagOrNot(Bag bag) {
        Ticket ticket = null;
        for (Locker locker : getLockers()) {
            if (locker.freeCapacity() > 0) {
                ticket = locker.depositBag(bag);
                break;
            }
        }
        return ticket;
    }

    public Ticket depositBag(Bag bag) {
        Ticket ticket = depositBagOrNot(bag);
        if (ticket == null) {
            throw new LockerFullException();
        }
        return ticket;
    }
}
