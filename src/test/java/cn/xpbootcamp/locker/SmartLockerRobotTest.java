package cn.xpbootcamp.locker;

import org.junit.Test;

public class SmartLockerRobotTest {

    @Test(expected = LockerFullException.class)
    public void should_return_prompt_when_deposit_bag_given_locker_is_full() {
        SmartLockerRobot robot = new SmartLockerRobot();
        Locker locker = new Locker(1);
        Bag bag = new Bag();
        locker.depositBag(bag);
        robot.addLocker(locker);
        robot.depositBag(bag);
    }

}
