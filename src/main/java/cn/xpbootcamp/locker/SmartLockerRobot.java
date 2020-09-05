package cn.xpbootcamp.locker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SmartLockerRobot {
    private List<Locker> lockers = new ArrayList<>();

    public void addLocker(Locker locker) {
        lockers.add(locker);
    }

    public Ticket depositBag(Bag bag) {
        List<Locker> notFullLockers = lockers
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

    public Bag pickUpBag(Ticket ticket) {
        for (Locker locker : lockers) {
            if (locker.isValidTicket(ticket)) {
                return locker.pickUpBag(ticket);
            }
        }
        throw new InvalidTicketException();
    }
}
