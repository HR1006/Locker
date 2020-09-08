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

    public Ticket depositBagByRobotType(Class<? extends Robot> clazz, Bag bag) {
        Ticket ticket = null;
        for (Robot robot : getRobotsByType(clazz)) {
            ticket = robot.depositBagOrNot(bag);
            if (ticket != null) {
                break;
            }
        }
        return ticket;
    }

    public List<Robot> getRobotsByType(Class<? extends Robot> clazz) {
        return robots
                .stream()
                .filter(clazz::isInstance)
                .collect(Collectors.toList());
    }

    public Ticket depositBag(Bag bag) {
        Ticket ticket;
        ticket = depositBagByRobotType(PrimaryLockerRobot.class, bag);
        if (ticket != null) {
            return ticket;
        }
        ticket = depositBagByRobotType(SmartLockerRobot.class, bag);
        if (ticket != null) {
            return ticket;
        }
        for (Locker locker : lockers) {
            if (locker.freeCapacity() > 0) {
                ticket = locker.depositBag(bag);
                return ticket;
            }
        }
        throw new LockerFullException();
    }

    public Bag pickUpBag(Ticket ticket) {
        for (Robot robot : getRobotsByType(PrimaryLockerRobot.class)) {
            if (robot.isValidTicket(ticket)) {
                return robot.pickUpBag(ticket);
            }
        }
        throw new InvalidTicketException();
    }
}
