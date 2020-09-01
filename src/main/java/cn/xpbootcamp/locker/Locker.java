package cn.xpbootcamp.locker;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    public static final String DEPOSIT_BAG_FAILED = "存包失败，储物柜已满！";
    public static final String PICK_UP_BAG_FAILED = "取包失败，非法票据！";

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

    private int surplusCapacity() {
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
