package cn.xpbootcamp.locker;

import org.junit.Test;

public class PrimaryLockerRobotTest {

    @Test(expected = LockerFullException.class)
    public void should_return_prompt_when_deposit_bag_given_locker_is_full() {
        PrimaryLockerRobot robot = new PrimaryLockerRobot();
        Locker locker = new Locker();
        locker.setLockerVolume(0);
        robot.addLocker(locker);
        Bag bag = new Bag();
        robot.depositBag(bag);
    }

}
