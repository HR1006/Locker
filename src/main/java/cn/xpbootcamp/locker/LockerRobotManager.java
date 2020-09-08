package cn.xpbootcamp.locker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LockerRobotManager {
    private final List<Robot> robots = new ArrayList<>();
    private final List<Locker> lockers = new ArrayList<>();

    public void addRobot(Robot robot) {
        robots.add(robot);
    }

    public void addLocker(Locker locker) {
        lockers.add(locker);
    }

    public Ticket depositBag(Bag bag) {
        Ticket ticket = null;
        List<PrimaryLockerRobot> primaryLockerRobots = robots
                .stream()
                .filter(robot -> robot instanceof PrimaryLockerRobot)
                .map(robot -> (PrimaryLockerRobot) robot)
                .collect(Collectors.toList());
        for (PrimaryLockerRobot primaryLockerRobot : primaryLockerRobots) {
            ticket = primaryLockerRobot.depositBagOrNot(bag);
            if (ticket != null) {
                break;
            }
        }
        if (ticket == null) {
            throw new LockerFullException();
        }
        return ticket;
    }
}
