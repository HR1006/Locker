package cn.xpbootcamp.locker;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SmartLockerRobot extends Robot {
    public Ticket depositBag(Bag bag) {
        List<Locker> notFullLockers = getLockers()
                .stream()
                .filter(locker -> locker.freeCapacity() > 0)
                .collect(Collectors.toList());
        if(notFullLockers.size() == 0) {
            throw new LockerFullException();
        }
        return notFullLockers
                .stream()
                .max(Comparator.comparingInt(Locker::freeCapacity))
                .get()
                .depositBag(bag);
    }
}
