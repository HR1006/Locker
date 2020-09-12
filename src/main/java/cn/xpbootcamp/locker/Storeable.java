package cn.xpbootcamp.locker;

import java.util.List;

public interface Storeable {

    Ticket depositBag(Bag bag);

    Bag pickUpBag(Ticket ticket);

    boolean isValidTicket(Ticket ticket);

    int freeCapacity();

    List<String> generateReport();

    int totalCapacity();
}
