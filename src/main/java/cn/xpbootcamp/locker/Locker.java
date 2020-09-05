package cn.xpbootcamp.locker;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private final int lockerCapacity;
    private final Map<Ticket, Bag> mapping = new HashMap<>();

    Locker(int lockerCapacity) {
        this.lockerCapacity = lockerCapacity;
    }

    public boolean isValidTicket(Ticket ticket) {
        return mapping.containsKey(ticket);
    }

    public int freeCapacity() {
        return lockerCapacity -  mapping.size();
    }

    public Ticket depositBag(Bag bag) {
        Ticket ticket = null;
        if (freeCapacity() == 0) {
            throw new LockerFullException();
        } else {
            ticket = new Ticket();
            mapping.put(ticket, bag);
        }
        return ticket;
    }

    public Bag pickUpBag(Ticket ticket) {
        Bag bag = mapping.remove(ticket);;
        if (bag == null) {
            throw new InvalidTicketException();
        }
        return bag;
    }
}
