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

    @Test
    public void should_return_ticket_when_deposit_bag_given_one_full_primary_locker_robot_and_one_full_smart_locker_robot_and_one_full_locker_and_one_not_full_locker() {
        primaryLockerRobot.depositBag(new Bag());
        smartLockerRobot.depositBag(new Bag());
        locker1.depositBag(new Bag());
        Bag bag = new Bag();
        Ticket ticket = lockerRobotManager.depositBag(bag);
        assertEquals(locker2.pickUpBag(ticket), bag);
    }

    @Test(expected = LockerFullException.class)
    public void should_return_prompt_when_deposit_bag_given_one_full_primary_locker_robot_and_one_full_smart_locker_robot_and_two_full_locker() {
        primaryLockerRobot.depositBag(new Bag());
        smartLockerRobot.depositBag(new Bag());
        locker1.depositBag(new Bag());
        locker2.depositBag(new Bag());
        lockerRobotManager.depositBag(new Bag());
    }

    @Test
    public void should_return_bag_when_pick_up_bag_given_one_primary_locker_robot_ticket() {
        Bag bag = new Bag();
        Ticket ticket = primaryLockerRobot.depositBag(bag);
        assertEquals(lockerRobotManager.pickUpBag(ticket), bag);
    }

    @Test(expected = InvalidTicketException.class)
    public void should_return_prompt_when_pick_up_bag_given_one_invalid_primary_locker_robot_ticket() {
        Bag bag = new Bag();
        primaryLockerRobot.depositBag(bag);
        Ticket ticket = new Ticket();
        lockerRobotManager.pickUpBag(ticket);
    }

    @Test
    public void should_return_bag_when_pick_up_bag_given_one_smart_locker_robot_ticket() {
        Bag bag = new Bag();
        Ticket ticket = smartLockerRobot.depositBag(bag);
        assertEquals(lockerRobotManager.pickUpBag(ticket), bag);
    }

    @Test(expected = InvalidTicketException.class)
    public void should_return_prompt_when_pick_up_bag_given_one_invalid_smart_locker_robot_ticket() {
        Bag bag = new Bag();
        smartLockerRobot.depositBag(bag);
        Ticket ticket = new Ticket();
        lockerRobotManager.pickUpBag(ticket);
    }

    @Test
    public void should_return_bag_when_pick_up_bag_given_one_locker_ticket() {
        Bag bag = new Bag();
        Ticket ticket = locker1.depositBag(bag);
        assertEquals(lockerRobotManager.pickUpBag(ticket), bag);
    }
}
