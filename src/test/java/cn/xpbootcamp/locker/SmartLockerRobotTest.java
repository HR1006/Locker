package cn.xpbootcamp.locker;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void should_return_ticket_when_deposit_bag_given_locker1_surplus_capacity_2_and_locker2_surplus_capacity_1() {
        SmartLockerRobot robot = new SmartLockerRobot();
        Locker locker1 = new Locker(2);
        robot.addLocker(locker1);
        Locker locker2 = new Locker(1);
        robot.addLocker(locker2);
        Bag bag = new Bag();
        Ticket ticket = robot.depositBag(bag);
        assertEquals(locker1.pickUpBag(ticket), bag);
    }

    @Test
    public void should_return_ticket_when_deposit_bag_given_locker1_surplus_capacity_1_and_locker2_surplus_capacity_2() {
        SmartLockerRobot robot = new SmartLockerRobot();
        Locker locker1 = new Locker(1);
        robot.addLocker(locker1);
        Locker locker2 = new Locker(2);
        robot.addLocker(locker2);
        Bag bag = new Bag();
        Ticket ticket = robot.depositBag(bag);
        assertEquals(locker2.pickUpBag(ticket), bag);
    }

    @Test
    public void should_return_ticket_when_deposit_bag_given_locker1_surplus_capacity_1_and_locker2_surplus_capacity_1() {
        SmartLockerRobot robot = new SmartLockerRobot();
        Locker locker1 = new Locker(1);
        robot.addLocker(locker1);
        Locker locker2 = new Locker(1);
        robot.addLocker(locker2);
        Bag bag = new Bag();
        Ticket ticket = robot.depositBag(bag);
        assertEquals(locker1.pickUpBag(ticket), bag);
    }

}
