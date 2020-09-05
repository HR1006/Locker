package cn.xpbootcamp.locker;

import java.util.UUID;

public class Ticket {
    private final String id;
    public Ticket() {
        id = UUID.randomUUID().toString();
    }
}
