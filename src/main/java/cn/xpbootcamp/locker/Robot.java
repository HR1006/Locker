package cn.xpbootcamp.locker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Robot implements Storeable {
    private final List<Locker> lockers = new ArrayList<>();

    public List<Locker> getLockers() {
        return lockers;
    }

    public void addLocker(Locker locker) {
        lockers.add(locker);
    }

    @Override
    public abstract Ticket depositBag(Bag bag);

    @Override
    public boolean isValidTicket(Ticket ticket) {
        for (Locker locker : getLockers()) {
            if (locker.isValidTicket(ticket)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Bag pickUpBag(Ticket ticket) {
        for (Locker locker : lockers) {
            if (locker.isValidTicket(ticket)) {
                return locker.pickUpBag(ticket);
            }
        }
        throw new InvalidTicketException();
    }

    public abstract Ticket depositBagOrNot(Bag bag);

    @Override
    public List<String> generateReport() {
        List<String> report = new ArrayList<>();
        report.add("R\t" + freeCapacity() + "\t" + getLockers().size());
        List<String> lockerReportList = getLockers()
                .stream()
                .map(locker -> "\t" + locker.generateReport())
                .collect(Collectors.toList());
        report.addAll(lockerReportList);
        return report;
    }

    @Override
    public int freeCapacity() {
        return lockers.stream().mapToInt(Locker::freeCapacity).sum();
    }

    @Override
    public int totalCapacity() {
        return lockers.stream().mapToInt(Locker::totalCapacity).sum();
    }
}
