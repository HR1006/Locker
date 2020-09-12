package cn.xpbootcamp.locker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrimaryLockerRobot extends Robot {
    @Override
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

    @Override
    public Ticket depositBag(Bag bag) {
        Ticket ticket = depositBagOrNot(bag);
        if (ticket == null) {
            throw new LockerFullException();
        }
        return ticket;
    }
}
