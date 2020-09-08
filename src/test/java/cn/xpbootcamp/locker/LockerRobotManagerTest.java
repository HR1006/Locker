package cn.xpbootcamp.locker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LockerRobotManagerTest {

    @Test
    public void should_return_ticket_when_deposit_bag_given_one_not_full_primary_locker_robot_and_one_not_full_smart_locker_robot_and_two_not_full_lockers() {
        LockerRobotManager lockerRobotManager = new LockerRobotManager();
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot();
        primaryLockerRobot.addLocker(new Locker(1));
        lockerRobotManager.addRobot(primaryLockerRobot);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot();
        smartLockerRobot.addLocker(new Locker(1));
        lockerRobotManager.addRobot(smartLockerRobot);
        Locker locker1 = new Locker(1);
        lockerRobotManager.addLocker(locker1);
        Locker locker2 = new Locker(1);
        lockerRobotManager.addLocker(locker2);
        Bag bag = new Bag();
        Ticket ticket = lockerRobotManager.depositBag(bag);
        assertEquals(primaryLockerRobot.pickUpBag(ticket), bag);
    }

}
