package cn.xpbootcamp.locker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LockerRobotDirector {
    private final List<LockerRobotManager> managers = new ArrayList<>();

    public void addLockerRobotManager(LockerRobotManager lockerRobotManager) {
        managers.add(lockerRobotManager);
    }

    public String generateReport() {
        return managers
                .stream()
                .map(manager -> String.join("\n", manager.generateReport()))
                .collect(Collectors.joining("\n"));
    }
}
