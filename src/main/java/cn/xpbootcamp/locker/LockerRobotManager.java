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
        List<Robot> primaryLockerRobots = robots
                .stream()
                .filter(robot -> robot instanceof PrimaryLockerRobot)
                .collect(Collectors.toList());
        for (Robot robot : primaryLockerRobots) {
            ticket = robot.depositBagOrNot(bag);
            if (ticket != null) {
                return ticket;
            }
        }
        List<Robot> smartLockerRobots = robots
                .stream()
                .filter(robot -> robot instanceof SmartLockerRobot)
                .collect(Collectors.toList());
        for (Robot robot : smartLockerRobots) {
            ticket = robot.depositBagOrNot(bag);
            if (ticket != null) {
                return ticket;
            }
        }
        if (ticket == null) {
            throw new LockerFullException();
        }
        return ticket;
    }
}
