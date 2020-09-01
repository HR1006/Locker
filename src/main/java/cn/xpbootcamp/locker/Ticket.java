package cn.xpbootcamp.locker;

import java.util.UUID;

public class Ticket {

    private String id;
    private Locker locker;

    public Ticket() {
        id = UUID.randomUUID().toString();
    }

    public Ticket(String id) {
        this.id = id;
    }

    public Ticket(Locker locker) {
        this.locker = locker;
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }
}
