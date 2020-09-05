package cn.xpbootcamp.locker;

import java.util.ArrayList;
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
                .filter(locker -> locker.surplusCapacity() > 0)
                .collect(Collectors.toList());
        if(notFullLockers.size() == 0) {
            throw new LockerFullException();
        }
        return notFullLockers.get(0).depositBag(bag);
    }
}
