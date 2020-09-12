package cn.xpbootcamp.locker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LockerRobotManager {
    private final List<Storeable> storeables = new ArrayList<>();

    public void addStoreable(Storeable storeable) {
        storeables.add(storeable);
    }

    public Ticket depositBagByToRobot(Bag bag) {
        Ticket ticket = null;
        List<Robot> robots = storeables
                .stream()
                .filter(storeable -> storeable instanceof Robot)
                .map(storeable -> (Robot) storeable)
                .collect(Collectors.toList());
        for (Robot robot : robots) {
            ticket = robot.depositBagOrNot(bag);
            if (ticket != null) {
                break;
            }
        }
        return ticket;
    }

    public Ticket depositBagByLocker(Bag bag) {
        Ticket ticket = null;
        List<Locker> lockers = storeables
                .stream()
                .filter(storeable -> storeable instanceof Locker)
                .map(storeable -> (Locker) storeable)
                .collect(Collectors.toList());
        for (Locker locker : lockers) {
            if (locker.freeCapacity() > 0) {
                ticket = locker.depositBag(bag);
                break;
            }
        }
        return ticket;
    }

    public Ticket depositBag(Bag bag) {
        Ticket ticket;
        ticket = depositBagByToRobot(bag);
        if (ticket != null) {
            return ticket;
        }
        ticket = depositBagByLocker(bag);
        if (ticket != null) {
            return ticket;
        }
        throw new LockerFullException();
    }

    public Bag pickUpBag(Ticket ticket) {
        for (Storeable storeable : storeables) {
            if (storeable.isValidTicket(ticket)) {
                return storeable.pickUpBag(ticket);
            }
        }
        throw new InvalidTicketException();
    }

    public int freeCapacity() {
        return storeables.stream().mapToInt(Storeable::freeCapacity).sum();
    }

    public List<String> generateReport() {
        List<String> report = new ArrayList<>();
        report.add("M\t" + freeCapacity() + "\t" + totalCapacity());
        storeables.stream().forEach(storeable -> storeable
                .generateReport()
                .forEach(storeableReport -> report.add("\t" + storeableReport)));
        return report;
    }

    private int totalCapacity() {
        return storeables.stream().mapToInt(Storeable::totalCapacity).sum();
    }
}
