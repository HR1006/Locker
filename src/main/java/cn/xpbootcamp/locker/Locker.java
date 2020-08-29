package cn.xpbootcamp.locker;

public class Locker {
    public static final String DEPOSIT_BAG_FAILED = "存包失败！";
    public static final String DEPOSIT_BAG_TICKET = "小票";
    private int idleNum;

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
}
