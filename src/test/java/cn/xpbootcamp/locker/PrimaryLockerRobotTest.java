package cn.xpbootcamp.locker;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimaryLockerRobotTest {

    @Test(expected = LockerFullException.class)
    public void should_return_prompt_when_deposit_bag_given_locker_is_full() {
        PrimaryLockerRobot robot = new PrimaryLockerRobot();
        Locker locker = new Locker(1);
        Bag bag1 = new Bag();
        locker.depositBag(bag1);
        robot.addLocker(locker);
        Bag bag2 = new Bag();
        robot.depositBag(bag2);
    }

    @Test
    public void should_return_ticket_when_deposit_bag_given_locker1_is_full_and_locker2_is_not_full() {
        PrimaryLockerRobot robot = new PrimaryLockerRobot();
        Locker locker1 = new Locker(1);
        Bag bag1 = new Bag();
        locker1.depositBag(bag1);
        robot.addLocker(locker1);
        Locker locker2 = new Locker(1);
        robot.addLocker(locker2);
        Bag bag2 = new Bag();
        Ticket ticket = robot.depositBag(bag2);
        assertEquals(locker2.pickUpBag(ticket), bag2);
    }

    @Test
    public void should_return_ticket_when_deposit_bag_given_locker1_is_not_full_and_locker2_is_not_full() {
        PrimaryLockerRobot robot = new PrimaryLockerRobot();
        Locker locker1 = new Locker(1);
        robot.addLocker(locker1);
        Locker locker2 = new Locker(1);
        robot.addLocker(locker2);
        Bag bag = new Bag();
        Ticket ticket = robot.depositBag(bag);
        assertEquals(locker1.pickUpBag(ticket), bag);
    }

    @Test
    public void should_return_bag_when_pick_up_bag_given_ticket_is_valid_and_deposit_bag_in_locker1() {
        PrimaryLockerRobot robot = new PrimaryLockerRobot();
        Locker locker1 = new Locker(1);
        robot.addLocker(locker1);
        Locker locker2 = new Locker(1);
        robot.addLocker(locker2);
        Bag bag = new Bag();
        Ticket ticket = robot.depositBag(bag);
        assertEquals(robot.pickUpBag(ticket), bag);
    }

    @Test
    public void should_return_bag_when_pick_up_bag_given_ticket_is_valid_and_deposit_bag_in_locker2() {
        PrimaryLockerRobot robot = new PrimaryLockerRobot();
        Locker locker1 = new Locker(1);
        robot.addLocker(locker1);
        Locker locker2 = new Locker(1);
        robot.addLocker(locker2);
        Bag bag = new Bag();
        Ticket ticket = robot.depositBag(bag);
        assertEquals(robot.pickUpBag(ticket), bag);
    }

    @Test(expected = InvalidTicketException.class)
    public void should_return_prompt_when_pick_up_bag_given_invalid_ticket() {
        PrimaryLockerRobot robot = new PrimaryLockerRobot();
        Locker locker1 = new Locker(1);
        robot.addLocker(locker1);
        Bag bag = new Bag();
        robot.depositBag(bag);
        Ticket ticket = new Ticket();
        robot.pickUpBag(ticket);
    }

    @Test(expected = InvalidTicketException.class)
    public void should_return_prompt_when_pick_up_bag_given_valid_ticket_but_has_been_used() {
        PrimaryLockerRobot robot = new PrimaryLockerRobot();
        Locker locker1 = new Locker(1);
        robot.addLocker(locker1);
        Bag bag = new Bag();
        Ticket ticket = robot.depositBag(bag);
        robot.pickUpBag(ticket);
        robot.pickUpBag(ticket);
    }

}
