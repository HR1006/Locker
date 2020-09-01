package cn.xpbootcamp.locker;

import java.util.HashMap;
import java.util.Map;

import static cn.xpbootcamp.locker.InvalidTicketException.PICK_UP_BAG_FAILED;
import static cn.xpbootcamp.locker.LockerFullException.DEPOSIT_BAG_FAILED;

public class Locker {
    private int lockerVolume;
    private final Map<Ticket, Bag> mapping = new HashMap<>();

    Locker() {
    }

    public int getLockerVolume() {
        return lockerVolume;
    }

    public void setLockerVolume(int lockerVolume) {
        this.lockerVolume = lockerVolume;
    }

    public int surplusCapacity() {
        return lockerVolume -  mapping.size();
    }

    public Ticket depositBag(Bag bag) {
        Ticket ticket = null;
        if (surplusCapacity() == 0) {
            throw new LockerFullException(PICK_UP_BAG_FAILED);
        } else {
            ticket = new Ticket();
            mapping.put(ticket, bag);
        }
        return ticket;
    }

    public Bag pickUpBag(Ticket ticket) {
        Bag bag = mapping.remove(ticket);;
        if (bag == null) {
            throw new InvalidTicketException(DEPOSIT_BAG_FAILED);
        }
        return bag;
    }
}
