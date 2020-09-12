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
        manager.addLocker(locker1);
        Locker locker2 = new Locker(2);
        manager.addLocker(locker2);
        director.addLockerRobotManager(manager);
        String report = director.generateReport();
        assertEquals(result, report);
    }

}
