package cn.xpbootcamp.locker;

import java.util.UUID;

public class Ticket {

    private String id;

    public Ticket() {
        id = UUID.randomUUID().toString();
    }

    public Ticket(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
