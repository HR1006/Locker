package cn.xpbootcamp.locker;

public class Locker {
    public static final String DEPOSIT_BAG_FAILED = "存包失败！";
    public static final String DEPOSIT_BAG_TICKET = "小票";
    public static final String BAG = "包";
    public static final String VALID_TICKET = "有效小票";
    public static final String VALID_TICKET_HAS_BEEN_USED = "已使用的有效小票";
    public static final String INVALID_TICKET = "无效小票";
    public static final String PICK_UP_BAG_FAILED = "票据无效！";
    private int idleNum;

    Locker() {
    }

    Locker(int idleNum) {
        this.idleNum = idleNum;
    }

    public int getIdleNum() {
        return idleNum;
    }

    public void setIdleNum(int idleNum) {
        this.idleNum = idleNum;
    }

    public void addIdleNum(int num) {
        setIdleNum(getIdleNum() - 1);
    }

    public String depositBag() {
        String result = null;
        if (idleNum == 0) {
            result = DEPOSIT_BAG_FAILED;
        }
        if (idleNum > 0) {
            addIdleNum(-1);
            result = DEPOSIT_BAG_TICKET;
        }
        return result;
    }

    public String pickUpBag(String ticket) {
        String result = null;
        if (VALID_TICKET.equals(ticket)) {
            result = BAG;
        }
        if (INVALID_TICKET.equals(ticket)) {
            result = PICK_UP_BAG_FAILED;
        }
        if (VALID_TICKET_HAS_BEEN_USED.equals(ticket)) {
            result = PICK_UP_BAG_FAILED;
        }
        return result;
    }
}
