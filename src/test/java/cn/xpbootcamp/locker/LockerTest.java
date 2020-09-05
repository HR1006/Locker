package cn.xpbootcamp.locker;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LockerTest {

    @Test(expected = LockerFullException.class)
    public void should_return_prompt_when_deposit_bag_given_locker_is_full() {
        Locker locker = new Locker(1);
        Bag bag1 = new Bag();
        locker.depositBag(bag1);
        Bag bag2 = new Bag();
        locker.depositBag(bag2);
    }

    @Test
    public void should_return_ticket_when_deposit_bag_given_locker_is_not_full() {
        Locker locker = new Locker(1);
        Bag bag = new Bag();
        Ticket ticket = locker.depositBag(bag);
        assertNotNull(ticket);
    }

    @Test
    public void should_return_bag_when_pick_up_bag_given_valid_ticket() {
        Locker locker = new Locker(1);
        Bag bag = new Bag();
        Ticket ticket = locker.depositBag(bag);
        assertEquals(locker.pickUpBag(ticket), bag);
    }

    @Test(expected = InvalidTicketException.class)
    public void should_return_prompt_when_pick_up_bag_given_invalid_ticket() {
        Locker locker = new Locker(1);
        Bag bag = new Bag();
        locker.depositBag(bag);
        Ticket invalidTicket = new Ticket();
        locker.pickUpBag(invalidTicket);
    }

    @Test(expected = InvalidTicketException.class)
    public void should_return_prompt_when_pick_up_bag_given_valid_ticket_but_has_been_used() {
        Locker locker = new Locker(1);
        Bag bag = new Bag();
        Ticket validTicket = locker.depositBag(bag);
        locker.pickUpBag(validTicket);
        locker.pickUpBag(validTicket);
    }

}
