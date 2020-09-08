package cn.xpbootcamp.locker;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SmartLockerRobot extends Robot {
    @Override
    public Ticket depositBagOrNot(Bag bag) {
        List<Locker> notFullLockers = getLockers()
                .stream()
                .filter(locker -> locker.freeCapacity() > 0)
                .collect(Collectors.toList());
        return notFullLockers.size() == 0 ? null : notFullLockers
                .stream()
                .max(Comparator.comparingInt(Locker::freeCapacity))
                .get()
                .depositBag(bag);
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
