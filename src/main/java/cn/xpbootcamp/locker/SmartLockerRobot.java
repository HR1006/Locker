package cn.xpbootcamp.locker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SmartLockerRobot {
    private List<Locker> lockers = new ArrayList<>();

    public void addLocker(Locker locker) {
        lockers.add(locker);
    }

    public void depositBag(Bag bag) {
        throw new LockerFullException();
    }
}
