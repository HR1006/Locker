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

}
