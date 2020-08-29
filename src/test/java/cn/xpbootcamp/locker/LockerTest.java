package cn.xpbootcamp.locker;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LockerTest {

    @Test
    public void should_return_prompt_when_deposit_bag_given_locker_is_empty() {
        Locker locker = new Locker(0);
        String depositBagResult = locker.depositBag();
        assertEquals(Locker.DEPOSIT_BAG_FAILED, depositBagResult);
    }

    @Test
    public void should_return_ticket_when_deposit_bag_given_locker_is_not_empty() {
        Locker locker = new Locker(1);
        String depositBagResult = locker.depositBag();
        assertEquals(Locker.DEPOSIT_BAG_TICKET, depositBagResult);
    }

    @Test
    public void should_return_bag_when_pick_up_bag_given_valid_ticket() {
        Locker locker = new Locker();
        String ticket = Locker.VALID_TICKET;
        String pickUpBagResult = locker.pickUpBag(ticket);
        assertEquals(Locker.BAG, pickUpBagResult);
    }

    @Test
    public void should_return_prompt_when_pick_up_bag_given_invalid_ticket() {
        Locker locker = new Locker();
        String ticket = Locker.INVALID_TICKET;
        String pickUpBagResult = locker.pickUpBag(ticket);
        assertEquals(Locker.PICK_UP_BAG_FAILED, pickUpBagResult);
    }

    @Test
    public void should_return_prompt_when_pick_up_bag_given_valid_ticket_but_has_been_used() {
        Locker locker = new Locker();
        String ticket = Locker.VALID_TICKET_HAS_BEEN_USED;
        String pickUpBagResult = locker.pickUpBag(ticket);
        assertEquals(Locker.PICK_UP_BAG_FAILED, pickUpBagResult);
    }

}
