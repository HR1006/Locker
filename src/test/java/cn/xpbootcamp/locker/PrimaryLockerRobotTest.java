package cn.xpbootcamp.locker;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void should_return_ticket_when_deposit_bag_given_locker1_is_full_and_locker2_is_not_full() {
        PrimaryLockerRobot robot = new PrimaryLockerRobot();
        Locker locker1 = new Locker();
        locker1.setLockerVolume(0);
        robot.addLocker(locker1);
        Locker locker2 = new Locker();
        locker2.setLockerVolume(1);
        robot.addLocker(locker2);
        Bag bag = new Bag();
        Ticket ticket = robot.depositBag(bag);
        assertEquals(ticket.getLocker(), locker2);
    }

    @Test
    public void should_return_ticket_when_deposit_bag_given_locker1_is_bot_full_and_locker2_is_not_full() {
        PrimaryLockerRobot robot = new PrimaryLockerRobot();
        Locker locker1 = new Locker();
        locker1.setLockerVolume(1);
        robot.addLocker(locker1);
        Locker locker2 = new Locker();
        locker1.setLockerVolume(1);
        robot.addLocker(locker2);
        Bag bag = new Bag();
        Ticket ticket = robot.depositBag(bag);
        assertEquals(ticket.getLocker(), locker1);
    }

    @Test
    public void should_return_bag_when_pick_up_bag_while_ticket_is_valid_and_deposit_bag_in_locker1() {
        PrimaryLockerRobot robot = new PrimaryLockerRobot();
        Locker locker1 = new Locker();
        locker1.setLockerVolume(1);
        robot.addLocker(locker1);
        Locker locker2 = new Locker();
        locker1.setLockerVolume(1);
        robot.addLocker(locker2);
        Bag bag = new Bag();
        Ticket ticket = robot.depositBag(bag);
        assertNotNull(robot.pickUpBag(ticket));
    }

}
