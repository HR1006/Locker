package cn.xpbootcamp.locker;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LockerRobotDirectorTest {

    @Test
    public void should_return_M_3_5_L_1_3_L_2_2_when_generate_report_given_one_manager_and_managed_two_lockers_and_locker1_free_1_total_3_locker2_free_2_total_2() {
        String result = "" +
                "M\t3\t5\n" +
                "\tL\t1\t3\n" +
                "\tL\t2\t2";
        LockerRobotDirector director = new LockerRobotDirector();
        LockerRobotManager manager = new LockerRobotManager();
        Locker locker1 = new Locker(3);
        locker1.depositBag(new Bag());
        locker1.depositBag(new Bag());
        manager.addStoreable(locker1);
        Locker locker2 = new Locker(2);
        manager.addStoreable(locker2);
        director.addLockerRobotManager(manager);
        String report = director.generateReport();
        assertEquals(result, report);
    }

    @Test
    public void should_return_M_4_9_R_3_5_L_1_3_L_2_2_R_1_4_L_1_2_L_0_2_when_generate_report_given_one_manager_and_managed_two_robots_and_robot1_locker1_free_1_total_3_robot1_locker2_free_2_total_2_and_robot2_locker1_free_1_total_2_robot2_locker2_free_0_total_2() {
        String result = "" +
                "M\t4\t9\n" +
                "\tR\t3\t5\n" +
                "\t\tL\t1\t3\n" +
                "\t\tL\t2\t2\n" +
                "\tR\t1\t4\n" +
                "\t\tL\t1\t2\n" +
                "\t\tL\t0\t2";
        LockerRobotDirector director = new LockerRobotDirector();
        LockerRobotManager manager = new LockerRobotManager();

        Robot robot1 = new PrimaryLockerRobot();
        Locker locker11 = new Locker(3);
        locker11.depositBag(new Bag());
        locker11.depositBag(new Bag());
        robot1.addLocker(locker11);
        Locker locker12 = new Locker(2);
        robot1.addLocker(locker12);
        manager.addStoreable(robot1);

        Robot robot2 = new PrimaryLockerRobot();
        Locker locker21 = new Locker(2);
        locker21.depositBag(new Bag());
        robot2.addLocker(locker21);
        Locker locker22 = new Locker(2);
        locker22.depositBag(new Bag());
        locker22.depositBag(new Bag());
        robot2.addLocker(locker22);
        manager.addStoreable(robot2);

        director.addLockerRobotManager(manager);
        String report = director.generateReport();
        assertEquals(result, report);
    }

    @Test
    public void should_return_M_3_5_R_1_3_L_1_3_L_2_2_when_generate_report_given_one_manager_and_one_locker_and_manager_managed_one_robots_and_robot_locker_free_1_total_3_and_manager_managed_locker_free_2_total_2() {
        String result = "" +
                "M\t3\t5\n" +
                "\tR\t1\t3\n" +
                "\t\tL\t1\t3\n" +
                "\tL\t2\t2";
        LockerRobotDirector director = new LockerRobotDirector();
        LockerRobotManager manager = new LockerRobotManager();

        Robot robot = new PrimaryLockerRobot();
        Locker locker1 = new Locker(3);
        locker1.depositBag(new Bag());
        locker1.depositBag(new Bag());
        robot.addLocker(locker1);
        manager.addStoreable(robot);

        Locker locker = new Locker(2);
        manager.addStoreable(locker);

        director.addLockerRobotManager(manager);
        String report = director.generateReport();
        assertEquals(result, report);
    }

    @Test
    public void should_return_M_1_3_L_1_3_M_2_2_L_2_2_when_generate_report_given_two_manager_and_manager1_managed_one_locker_free_1_total_3_and_manager2_managed_one_locker_free_2_total_2() {
        String result = "" +
                "M\t1\t3\n" +
                "\tL\t1\t3\n" +
                "M\t2\t2\n" +
                "\tL\t2\t2";
        LockerRobotDirector director = new LockerRobotDirector();

        LockerRobotManager manager1 = new LockerRobotManager();
        Locker locker1 = new Locker(3);
        locker1.depositBag(new Bag());
        locker1.depositBag(new Bag());
        manager1.addStoreable(locker1);
        director.addLockerRobotManager(manager1);

        LockerRobotManager manager2 = new LockerRobotManager();
        Locker locker2 = new Locker(2);
        manager2.addStoreable(locker2);
        director.addLockerRobotManager(manager2);

        String report = director.generateReport();
        assertEquals(result, report);
    }

}
