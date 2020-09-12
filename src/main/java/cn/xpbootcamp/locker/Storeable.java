package cn.xpbootcamp.locker;

public interface Storeable {

    Ticket depositBag(Bag bag);

    Bag pickUpBag(Ticket ticket);

    boolean isValidTicket(Ticket ticket);

}
