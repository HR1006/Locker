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

}
