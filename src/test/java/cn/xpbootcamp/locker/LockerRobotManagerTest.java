package cn.xpbootcamp.locker;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LockerRobotManagerTest {
    private LockerRobotManager lockerRobotManager;
    private PrimaryLockerRobot primaryLockerRobot;
    private SmartLockerRobot smartLockerRobot;
    private Locker locker1;
    private Locker locker2;

    @Before
    public void before() {
        lockerRobotManager = new LockerRobotManager();
        primaryLockerRobot = new PrimaryLockerRobot();
        primaryLockerRobot.addLocker(new Locker(1));
        lockerRobotManager.addRobot(primaryLockerRobot);
        smartLockerRobot = new SmartLockerRobot();
        smartLockerRobot.addLocker(new Locker(1));
        lockerRobotManager.addRobot(smartLockerRobot);
        locker1 = new Locker(1);
        lockerRobotManager.addLocker(locker1);
        locker2 = new Locker(1);
        lockerRobotManager.addLocker(locker2);
    }

    @Test
    public void should_return_ticket_when_deposit_bag_given_one_not_full_primary_locker_robot_and_one_not_full_smart_locker_robot_and_two_not_full_lockers() {
        Bag bag = new Bag();
        Ticket ticket = lockerRobotManager.depositBag(bag);
        assertEquals(primaryLockerRobot.pickUpBag(ticket), bag);
    }

    @Test
    public void should_return_ticket_when_deposit_bag_given_one_full_primary_locker_robot_and_one_not_full_smart_locker_robot_and_two_not_full_lockers() {
        primaryLockerRobot.depositBag(new Bag());
        Bag bag = new Bag();
        Ticket ticket = lockerRobotManager.depositBag(bag);
        assertEquals(smartLockerRobot.pickUpBag(ticket), bag);
    }

    @Test
    public void should_return_ticket_when_deposit_bag_given_one_full_primary_locker_robot_and_one_full_smart_locker_robot_and_two_not_full_lockers() {
        primaryLockerRobot.depositBag(new Bag());
        smartLockerRobot.depositBag(new Bag());
        Bag bag = new Bag();
        Ticket ticket = lockerRobotManager.depositBag(bag);
        assertEquals(locker1.pickUpBag(ticket), bag);
    }

}
